package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.exception.ResourceNotFoundException;
import com.joaovictorcmd.swiftstore.mapper.OrderMapper;
import com.joaovictorcmd.swiftstore.model.dto.OrderDTO;
import com.joaovictorcmd.swiftstore.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        return orderRepository.findById(id)
                .map(orderMapper::toDTO)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Resource not found")
                );
    }
}
