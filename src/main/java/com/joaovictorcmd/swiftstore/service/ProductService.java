package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.model.dto.ProductDTO;
import com.joaovictorcmd.swiftstore.model.dto.ProductMinDTO;
import com.joaovictorcmd.swiftstore.model.entity.Product;
import com.joaovictorcmd.swiftstore.exception.DatabaseException;
import com.joaovictorcmd.swiftstore.exception.ResourceNotFoundException;
import com.joaovictorcmd.swiftstore.mapper.ProductMapper;
import com.joaovictorcmd.swiftstore.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = productMapper.toEntity(productDTO);
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }

    @Transactional(readOnly = true)
    public Page<ProductMinDTO> findAll(String name, Pageable pageable) {
        Page<Product> products = productRepository.searchByName(name, pageable);
        return products.map(productMapper::toMinDTO);
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(productMapper::toDTO)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Resource not found")
                );
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );
        productMapper.updateEntityFromDTO(productDTO, product);
        return productMapper.toDTO(product);
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new ResourceNotFoundException("Resource not found");
        }

        try {
            productRepository.deleteById(id);
        } catch (DataIntegrityViolationException exception) {
            throw new DatabaseException("Referential integrity failure");
        }
    }
}
