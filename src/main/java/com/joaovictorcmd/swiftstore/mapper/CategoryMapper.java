package com.joaovictorcmd.swiftstore.mapper;

import com.joaovictorcmd.swiftstore.model.dto.CategoryDTO;
import com.joaovictorcmd.swiftstore.model.entity.Category;
import org.mapstruct.Mapper;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 24
 */
@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryDTO toDTO(Category category);

    Category toEntity(CategoryDTO categoryDTO);
}
