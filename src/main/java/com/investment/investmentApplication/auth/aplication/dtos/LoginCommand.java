package com.investment.investmentApplication.auth.aplication.dtos;

/**
 * The Class LoginCommand
 *
 * @author Pedro Junho Silveira
 * @since 24/07/2026
 */

public record LoginCommand (

        String email,

        String password
){
}
