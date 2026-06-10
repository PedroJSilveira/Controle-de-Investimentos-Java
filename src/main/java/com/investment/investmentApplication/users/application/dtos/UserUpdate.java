package com.investment.investmentApplication.users.application.dtos;

import java.time.LocalDate;

public record UserUpdate(
        String name,

        String document,

        String email,

        String password,

        LocalDate birthday
) {
}
