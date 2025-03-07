package com.joaovictorcmd.swiftstore.model.mapper;

import com.joaovictorcmd.swiftstore.model.dto.OrderDTO;
import com.joaovictorcmd.swiftstore.model.entity.Order;
import org.mapstruct.Mapper;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class, PaymentMapper.class, OrderItemMapper.class})
public interface OrderMapper {

    OrderDTO toDTO(Order order);

    Order toEntity(OrderDTO orderDTO);
}
