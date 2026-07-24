package com.investment.investmentApplication.auth.aplication.usecases;

import com.investment.investmentApplication.auth.aplication.dtos.LoginCommand;
import com.investment.investmentApplication.auth.aplication.dtos.TokenResponse;
import com.investment.investmentApplication.auth.infraestructure.security.JwtService;
import com.investment.investmentApplication.shared.application.usecases.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

/**
 * The Class LoginUseCase
 *
 * @author Pedro Junho Silveira
 * @since 24/07/2026
 */

@Component
@RequiredArgsConstructor
public class LoginUseCase implements UseCase<LoginCommand, TokenResponse> {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @Override
    public TokenResponse execute(final LoginCommand input) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(input.email(), input.password())
        );

        String token = jwtService.generateToken(input.email());

        return TokenResponse.of(token, 86400000L);
    }

}
