package com.joaovictorcmd.swiftstore.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 03
 */
@AllArgsConstructor
@Getter
public class FieldMessage {

    private String fieldName;
    private String message;
}
