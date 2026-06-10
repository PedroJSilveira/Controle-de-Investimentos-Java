package com.investment.investmentApplication.users.application.dtos;

import java.time.LocalDate;

public record UserCreate(

        String name,

        String document,

        String email,

        String password,

        LocalDate birthday
) {
}
