package com.investment.investmentApplication.users.application.usecases.update_user_usecase;

import com.investment.investmentApplication.users.application.dtos.UserUpdate;
import com.investment.investmentApplication.users.domain.UserId;

import java.time.LocalDate;

public record UserUpdateCommand (

        UserId id,

        String name,

        String document,

        String email,

        String password,

        LocalDate birthday
){

    public static UserUpdateCommand converter(UserId anId, UserUpdate anUser){
        return new UserUpdateCommand(
                anId,
                anUser.name(),
                anUser.document(),
                anUser.email(),
                anUser.password(),
                anUser.birthday()
        );
    }
}
