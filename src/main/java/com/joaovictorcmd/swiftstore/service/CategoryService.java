package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.mapper.CategoryMapper;
import com.joaovictorcmd.swiftstore.model.dto.CategoryDTO;
import com.joaovictorcmd.swiftstore.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 27
 */
@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toDTO)
                .toList();
    }
}
