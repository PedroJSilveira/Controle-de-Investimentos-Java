package com.investment.investmentApplication.application.controls.entities;

import java.time.LocalDateTime;

/**
 * The Class ErrorHandling
 *
 * @author Pedro Junho Silveira
 * @since 31/10/2025
 */
public record ErrorHandling(
        String timestamps,

        int statusCode,

        String path,

        String method,

        String message
) {

    public static ErrorHandling generate(int statusCode, String path, String method, String message) {
        return new ErrorHandling(LocalDateTime.now().toString(), statusCode, path, method, message);
    }
}
