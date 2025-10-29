package com.investment.investmentApplication.investments.entities.dtos;

import java.time.LocalDate;

/**
 * The Class Investment
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

public record Investment(

        String name,

        String type,

        LocalDate investmentDate,

        Double value

) {
}
