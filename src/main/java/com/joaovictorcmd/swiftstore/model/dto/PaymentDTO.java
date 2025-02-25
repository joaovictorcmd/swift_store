package com.joaovictorcmd.swiftstore.model.dto;

import java.time.Instant;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
public record PaymentDTO(
        Long id,
        Instant moment
) {
}
