package com.investment.investmentApplication.investments.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.investment.investmentApplication.investments.domain.Type;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

/**
 * The Class InvestmentCreate
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */
public record InvestmentCreate(

        @Schema(description = "Nome do investimento", example = "Tesouro Direto")
        String name,

        @Schema(description = "Tipo do investimento", example = "TESOURO_DIRETO")
        Type type,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Data do investimento", example = "25/07/2026")
        LocalDate investmentDate,

        @Schema(description = "Valor do investimento", example = "15000.0")
        Double value

) {
}
