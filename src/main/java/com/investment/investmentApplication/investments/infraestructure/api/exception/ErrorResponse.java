package com.investment.investmentApplication.investments.infraestructure.api.exception;

import java.time.LocalDateTime;

/**
 * The Class ErrorResponse
 *
 * @author Pedro Junho Silveira
 * @since 31/10/2025
 */

public record ErrorResponse(
        String timestamps,

        int statusCode,

        String path,

        String method,

        String message
) {

    public static ErrorResponse generate(int statusCode, String path, String method, String message) {
        return new ErrorResponse(LocalDateTime.now().toString(), statusCode, path, method, message);
    }
}
