package com.joaovictorcmd.swiftstore.exception.handlers;

import com.joaovictorcmd.swiftstore.exception.DatabaseException;
import com.joaovictorcmd.swiftstore.exception.ErrorResponse;
import com.joaovictorcmd.swiftstore.exception.ResourceNotFoundException;
import com.joaovictorcmd.swiftstore.exception.ValidationError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;

/**
 * @author joaovictorcmd
 * @date 2025 Feb 03
 */
@RestControllerAdvice
public class ControllerAdviceHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> resourceNotFoundHandler(ResourceNotFoundException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                status.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<ErrorResponse> databaseHandler(DatabaseException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        ErrorResponse error = new ErrorResponse(
                Instant.now(),
                status.value(),
                exception.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception, HttpServletRequest request) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
        ValidationError error = new ValidationError(
                Instant.now(),
                status.value(),
                "Invalid data",
                request.getRequestURI()
        );
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
            error.addError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(status).body(error);
    }
}
