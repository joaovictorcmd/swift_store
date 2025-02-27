package com.joaovictorcmd.swiftstore.controller;

import com.joaovictorcmd.swiftstore.model.dto.CategoryDTO;
import com.joaovictorcmd.swiftstore.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 27
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> categoriesDTO = categoryService.findAll();
        return ResponseEntity.ok(categoriesDTO);
    }
}
