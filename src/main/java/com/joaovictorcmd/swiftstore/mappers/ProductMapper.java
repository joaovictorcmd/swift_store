package com.joaovictorcmd.swiftstore.mappers;

import com.joaovictorcmd.swiftstore.dto.ProductDTO;
import com.joaovictorcmd.swiftstore.entities.Product;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

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