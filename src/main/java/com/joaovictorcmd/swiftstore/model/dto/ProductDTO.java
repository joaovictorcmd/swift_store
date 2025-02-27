package com.joaovictorcmd.swiftstore.model.dto;

import jakarta.validation.constraints.*;
import org.hibernate.validator.constraints.URL;

import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
public record ProductDTO(
        Long id,

        @Size(min = 3, max = 80, message = "Name must be between 3 and 80 characters")
        @NotBlank(message = "Required field")
        String name,

        @Size(min = 10, message = "Description must be at least 10 characters")
        @NotBlank(message = "Required field")
        String description,

        @Positive(message = "Price must be a positive value")
        @NotNull(message = "Required field")
        Double price,

        @URL(message = "Invalid URL")
        @NotBlank(message = "Required field")
        String imgUrl,

        @NotEmpty(message = "Required field")
        List<CategoryDTO> categories
) {
}
