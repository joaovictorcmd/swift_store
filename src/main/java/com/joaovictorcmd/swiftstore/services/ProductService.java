package com.joaovictorcmd.swiftstore.services;

import com.joaovictorcmd.swiftstore.dto.ProductDTO;
import com.joaovictorcmd.swiftstore.entities.Product;
import com.joaovictorcmd.swiftstore.mappers.ProductMapper;
import com.joaovictorcmd.swiftstore.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper.INSTANCE::toProductDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id) {
        return productRepository.findById(id)
                .map(ProductMapper.INSTANCE::toProductDTO)
                .orElseThrow();
    }

    @Transactional
    public ProductDTO insert(ProductDTO productDTO) {
        Product product = ProductMapper.INSTANCE.toProduct(productDTO);
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.toProductDTO(product);
    }

    @Transactional
    public ProductDTO update(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow();
        ProductMapper.INSTANCE.updateProductFromDTO(productDTO, product);
        product = productRepository.save(product);
        return ProductMapper.INSTANCE.toProductDTO(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
