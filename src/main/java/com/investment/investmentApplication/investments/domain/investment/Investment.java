package com.investment.investmentApplication.investments.domain.investment;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * The Class Investment
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

public record Investment(

        @NotNull
        String name,

        @NotNull
        String type,

        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate investmentDate,

        @NotNull
        Double value

) {
}
