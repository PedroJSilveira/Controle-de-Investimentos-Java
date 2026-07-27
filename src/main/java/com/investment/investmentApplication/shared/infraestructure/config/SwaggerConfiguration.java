package com.investment.investmentApplication.shared.infraestructure.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * The Class SwaggerConfiguration
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@Configuration
@OpenAPIDefinition
@SecurityScheme(
        name = "bearerAuth",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        description = "Informe o token JWT"
)
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Investments API")
                        .description("Documentation for Investments API")
                        .contact(new Contact()
                                .name("Pedro Junho Silveira")
                                .email("pedrojunhocontato@gmail.com"))
                );
    }

}
