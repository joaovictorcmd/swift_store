package com.joaovictorcmd.swiftstore.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public record LoginRequestDTO(
        @NotBlank(message = "Required field")
        @Email(message = "Invalid email")
        String email,

        @NotBlank(message = "Required field")
        String password
) {
}
