package com.investment.investmentApplication.investments.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

public record InvestmentUpdate(

        @Schema(description = "Nome do investimento", example = "Tesouro Direto")
        String name,

        @Schema(description = "Tipo do investimento", example = "Tesouro Direto")
        String type,

        @JsonFormat(pattern = "dd/MM/yyyy")
        @Schema(description = "Data do investimento", example = "25/07/2026")
        LocalDate investmentDate,

        @Schema(description = "Valor do investimento", example = "15000.0")
        Double value

) {
}
