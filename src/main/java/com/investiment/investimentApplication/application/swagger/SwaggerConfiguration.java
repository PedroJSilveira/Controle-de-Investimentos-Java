package com.investiment.investimentApplication.application.swagger;

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
public class SwaggerConfiguration {

    @Bean
    public OpenAPI swaggerOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Investiments API")
                        .description("Documentation for Investments API")
                        .contact(new Contact()
                                .name("Pedro Junho Silveira")
                                .email("pedrojunhocontato@gmail.com"))
                );
    }

}
