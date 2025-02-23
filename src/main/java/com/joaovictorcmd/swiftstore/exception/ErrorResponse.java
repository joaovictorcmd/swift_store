package com.joaovictorcmd.swiftstore.exception;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 03
 */
@AllArgsConstructor
@Getter
public class ErrorResponse {

    private Instant timestamp;
    private Integer status;
    private String error;
    private String path;
}
