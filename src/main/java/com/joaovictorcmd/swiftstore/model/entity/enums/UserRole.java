package com.joaovictorcmd.swiftstore.model.entity.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 04
 */
@AllArgsConstructor
@Getter
public enum UserRole {

    ADMIN("admin"),
    USER("user");

    private String role;
}
