package com.joaovictorcmd.swiftstore.model.mapper;

import com.joaovictorcmd.swiftstore.model.dto.OrderItemDTO;
import com.joaovictorcmd.swiftstore.model.entity.associations.OrderItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Mapper(componentModel = "spring")
public interface OrderItemMapper {

    @Mapping(target = "productId", source = "id.product.id")
    @Mapping(target = "name", source = "id.product.name")
    @Mapping(target = "imgUrl", source = "id.product.imgUrl")
    OrderItemDTO toDTO(OrderItem orderItem);
}
