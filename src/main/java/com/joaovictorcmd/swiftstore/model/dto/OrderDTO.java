package com.joaovictorcmd.swiftstore.model.dto;

import com.joaovictorcmd.swiftstore.model.entity.enums.OrderStatus;

import java.time.Instant;
import java.util.Set;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
public record OrderDTO(
        Long id,
        Instant moment,
        OrderStatus status,
        UserMinDTO client,
        PaymentDTO payment,
        Set<OrderItemDTO> items
) {
    public Double getTotal() {
        return items.stream()
                .mapToDouble(OrderItemDTO::getSubtotal)
                .sum();
    }
}
