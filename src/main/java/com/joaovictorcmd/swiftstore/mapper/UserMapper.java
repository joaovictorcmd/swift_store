package com.joaovictorcmd.swiftstore.mapper;

import com.joaovictorcmd.swiftstore.model.dto.UserMinDTO;
import com.joaovictorcmd.swiftstore.model.entity.User;
import org.mapstruct.Mapper;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 25
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMinDTO toMinDTO(User user);
}
