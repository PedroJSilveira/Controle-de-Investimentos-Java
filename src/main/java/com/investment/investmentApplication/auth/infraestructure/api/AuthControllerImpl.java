package com.investment.investmentApplication.auth.infraestructure.api;

import com.investment.investmentApplication.auth.aplication.dtos.LoginCommand;
import com.investment.investmentApplication.auth.aplication.dtos.TokenResponse;
import com.investment.investmentApplication.auth.aplication.usecases.LoginUseCase;
import com.investment.investmentApplication.auth.infraestructure.api.interfaces.AuthController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class AuthController
 *
 * @author Pedro Junho Silveira
 * @since 27/07/2026
 */

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private final LoginUseCase loginUseCase;

    @Override
    public ResponseEntity<TokenResponse> login(final LoginCommand input) {
        return ResponseEntity.status(HttpStatus.OK).body(loginUseCase.execute(input));
    }

}
