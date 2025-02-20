package com.joaovictorcmd.swiftstore.dto;

import com.joaovictorcmd.swiftstore.entities.UserRole;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 18
 */
public record RegisterDTO(

        @NotBlank(message = "Required field")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Required field")
        @Size(max = 255, message = "Email must be at most 255 characters")
        @Email(message = "Invalid email format")
        String email,

        @NotBlank(message = "Required field")
        @Pattern(
                regexp = "\\d{10,15}",
                message = "Phone number must contain only numbers and be between 10 and 15 digits"
        )
        String phone,


        @NotNull(message = "Required field")
        @Past(message = "Birthdate must be in the past")
        LocalDate birthDate,


        @NotBlank(message = "Required field")
        @Size(min = 8, message = "Password must be at least 8 characters")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "Password must contain at least one uppercase letter, one lowercase letter, one number, and one special character"
        )
        String password,

        @NotNull(message = "Required field")
        UserRole role
) {
}
