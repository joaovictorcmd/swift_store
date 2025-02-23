package com.joaovictorcmd.swiftstore.exception;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 23
 */
public class EmailAlreadyExistsException extends RuntimeException {

    public EmailAlreadyExistsException(String message) {
        super(message);
    }
}
