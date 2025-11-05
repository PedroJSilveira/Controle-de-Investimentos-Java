package com.investment.investmentApplication.application.controls.exceptions;

import com.investment.investmentApplication.application.controls.entities.ErrorHandling;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * The Class ControllerException
 *
 * @author Pedro Junho Silveira
 * @since 31/10/2025
 */

@RestControllerAdvice
public class ControllerException {

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ErrorHandling> missingException(MissingServletRequestParameterException ex, HttpServletRequest request) {
        String message = "Parameter ".concat(ex.getParameterName()).concat(" is not in the request.");
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorHandling.generate(HttpStatus.BAD_REQUEST.value(), request.getServletPath(), request.getMethod(), message)
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorHandling> methodException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> emptyFields = ex.getBindingResult().getFieldErrors().stream()
                .filter(error -> Objects.equals(error.getCode(), "NotBlank"))
                .map(FieldError::getField).collect(Collectors.toList());

        List<String> invalidFields = ex.getBindingResult().getFieldErrors().stream()
                .filter(error -> !Objects.equals(error.getCode(), "NotBlank"))
                .map(FieldError::getField).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorHandling.generate(HttpStatus.BAD_REQUEST.value(), request.getServletPath(), request.getMethod(), message(emptyFields, invalidFields))
        );
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorHandling> applicationException(HttpMessageNotReadableException ex, HttpServletRequest request) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                ErrorHandling.generate(HttpStatus.BAD_REQUEST.value(), request.getServletPath(), request.getMethod(), "JSON is not formatted")
        );
    }
    private String message(List<String> emptyFields, List<String> invalidFields) {
        StringBuilder errorMessage = new StringBuilder();

        if (!emptyFields.isEmpty()) {
            String prefix = emptyFields.size() > 1 ? "The fields " : "The field ";
            String body = String.join(", ", emptyFields);
            String sufix = "can not be empty or null ";

            errorMessage.append(prefix).append(body).append(sufix);
        }

        invalidFields.removeAll(emptyFields);

        if (!invalidFields.isEmpty()) {
            String prefix = invalidFields.size() > 1 ? "The fields " : "The field ";
            String body = String.join(", ", invalidFields);
            String sufix = invalidFields.size() > 1 ? " are invalid." : " is invalid.";

            errorMessage.append(prefix).append(body).append(sufix);
        }

        return errorMessage.toString().isEmpty() ? null : errorMessage.toString();
    }

}
