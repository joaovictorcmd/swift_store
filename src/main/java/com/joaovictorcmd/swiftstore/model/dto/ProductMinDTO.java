package com.joaovictorcmd.swiftstore.model.dto;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 24
 */
public record ProductMinDTO(
        Long id,
        String name,
        Double price,
        String imgUrl
) {
}
