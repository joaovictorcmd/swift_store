package com.joaovictorcmd.swiftstore.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public record LoginRequestDTO(
        @NotBlank(message = "Required field")
        @Size(max = 255, message = "Email must be at most 255 characters")
        @Email(message = "Invalid email")
        String email,

        @NotBlank(message = "Required field")
        @Size(min = 8, max = 64, message = "Password must be between 8 and 64 characters")
        String password
) {
}
