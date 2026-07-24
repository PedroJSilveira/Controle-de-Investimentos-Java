package com.investment.investmentApplication.auth.aplication.dtos;

import org.antlr.v4.runtime.Token;

/**
 * The Class TokenResponse
 *
 * @author Pedro Junho Silveira
 * @since 24/07/2026
 */

public record TokenResponse (

    String token,

    String type,

    Long expiresIn

){
    public static TokenResponse of(String token, Long expiresIn){
        return new TokenResponse(token, "Bearer", expiresIn);
    }
}
