package com.joaovictorcmd.swiftstore.model.dto;

import java.time.Instant;
import java.util.List;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 20
 */
public record LoginResponseDTO(
        String accessToken,
        Instant expiresAt,
        Long userId,
        String email,
        String name,
        List<String> roles
) {
}
