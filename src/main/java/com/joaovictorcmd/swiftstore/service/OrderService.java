package com.joaovictorcmd.swiftstore.service;

import com.joaovictorcmd.swiftstore.exception.ResourceNotFoundException;
import com.joaovictorcmd.swiftstore.model.mapper.OrderMapper;
import com.joaovictorcmd.swiftstore.model.dto.OrderDTO;
import com.joaovictorcmd.swiftstore.model.dto.OrderItemDTO;
import com.joaovictorcmd.swiftstore.model.entity.Order;
import com.joaovictorcmd.swiftstore.model.entity.Product;
import com.joaovictorcmd.swiftstore.model.entity.User;
import com.joaovictorcmd.swiftstore.model.entity.associations.OrderItem;
import com.joaovictorcmd.swiftstore.model.entity.enums.OrderStatus;
import com.joaovictorcmd.swiftstore.model.repository.OrderItemRepository;
import com.joaovictorcmd.swiftstore.model.repository.OrderRepository;
import com.joaovictorcmd.swiftstore.model.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderMapper orderMapper;
    private final OrderRepository orderRepository;
    private final AuthService authService;
    private final ProductRepository productRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional(readOnly = true)
    public OrderDTO findById(Long id) {
        Order order = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Resource not found")
        );

        authService.validateSelfOrAdmin(order.getClient().getId());

        return orderMapper.toDTO(order);
    }

    @Transactional
    public OrderDTO insert(OrderDTO orderDTO) {
        User user = authService.authenticated();

        Order order = new Order();
        order.setMoment(Instant.now());
        order.setStatus(OrderStatus.WAITING_PAYMENT);
        order.setClient(user);

        for (OrderItemDTO itemDTO : orderDTO.items()) {
            Product product = productRepository.getReferenceById(itemDTO.productId());
            OrderItem item = new OrderItem(order, product, itemDTO.quantity(), product.getPrice());
            order.getItems().add(item);
        }

        order = orderRepository.save(order);
        orderItemRepository.saveAll(order.getItems());

        return orderMapper.toDTO(order);
    }
}
