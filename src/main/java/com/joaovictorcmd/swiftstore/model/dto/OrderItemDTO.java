package com.joaovictorcmd.swiftstore.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
public record OrderItemDTO(
        Long productId,
        String name,
        Double price,
        Integer quantity
) {
    @JsonProperty("subtotal")
    public Double getSubtotal() {
        return price * quantity;
    }
}
