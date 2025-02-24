package com.joaovictorcmd.swiftstore.exception;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 24
 */
public class UserNotAuthenticatedException extends RuntimeException {
    public UserNotAuthenticatedException(String message) {
        super(message);
    }
}
