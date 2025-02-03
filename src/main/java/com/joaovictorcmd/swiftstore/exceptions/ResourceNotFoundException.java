package com.joaovictorcmd.swiftstore.exceptions;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 03
 */
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
