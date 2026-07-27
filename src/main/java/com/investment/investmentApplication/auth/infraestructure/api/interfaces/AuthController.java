package com.investment.investmentApplication.auth.infraestructure.api.interfaces;

import com.investment.investmentApplication.auth.aplication.dtos.LoginCommand;
import com.investment.investmentApplication.auth.aplication.dtos.TokenResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The Class AuthController
 *
 * @author Pedro Junho Silveira
 * @since 27/07/2026
 */

@RestController
@RequestMapping("/auth")
@Tag(name= "Auth Module")
public interface AuthController {

    @Operation(
            summary = "Login",
            responses = {
                    @ApiResponse(description = "Token",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = TokenResponse.class)
                            )
                    )
            }
    )
    @ApiResponse(responseCode= "200")
    @PostMapping("/login")
    ResponseEntity<TokenResponse> login(
            @RequestBody LoginCommand user
    );

}
