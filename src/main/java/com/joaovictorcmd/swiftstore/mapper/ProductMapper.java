package com.joaovictorcmd.swiftstore.mapper;

import com.joaovictorcmd.swiftstore.model.dto.ProductDTO;
import com.joaovictorcmd.swiftstore.model.entity.Product;
import org.mapstruct.*;

/**
 * @author joaovictorcmd
 * @date 2025 Jan 29
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductDTO toDTO(Product product);

    @Mapping(target = "categories", ignore = true)
    @Mapping(target = "items", ignore = true)
    Product toEntity(ProductDTO productDTO);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateEntityFromDTO(ProductDTO productDTO, @MappingTarget Product product);
}