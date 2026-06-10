package com.investment.investmentApplication.users.domain;

import com.investment.investmentApplication.shared.domain.Aggregate;
import com.investment.investmentApplication.users.application.dtos.UserCreate;
import com.investment.investmentApplication.users.application.usecases.update_user_usecase.UserUpdateCommand;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class User extends Aggregate<UserId> {

    private String name;

    private String document;

    private String email;

    private String password;

    private LocalDate birthday;

    private User(
            LocalDateTime aCreatedAt,
            LocalDateTime anUpdatedAt,
            LocalDateTime aDisabledAt,
            boolean aDisabled,
            UserId anId,
            String name,
            String document,
            String email,
            String password,
            LocalDate birthday
    ) {
        super(aCreatedAt, anUpdatedAt, aDisabledAt, aDisabled, anId);
        this.name = name;
        this.document = document;
        this.email = email;
        this.password = password;
        this.birthday = birthday;
    }

    public static User generate(UserCreate anInput) {
        return new  User(
                LocalDateTime.now(),
                LocalDateTime.now(),
                null,
                false,
                UserId.unique(),
                anInput.name(),
                anInput.document(),
                anInput.email(),
                anInput.password(),
                anInput.birthday()
        );
    }

    public static User from(
            LocalDateTime aCreatedAt,
            LocalDateTime anUpdatedAt,
            LocalDateTime aDisabledAt,
            boolean aDisabled,
            UserId anId,
            String name,
            String document,
            String email,
            String password,
            LocalDate birthday
    ){
        return new User(
                aCreatedAt,
                anUpdatedAt,
                aDisabledAt,
                aDisabled,
                anId,
                name,
                document,
                email,
                password,
                birthday
        );
    }

    public User update(UserUpdateCommand anUser){
        this.name = anUser.name();
        this.document = anUser.document();
        this.email = anUser.email();
        this.password = anUser.password();
        this.birthday = anUser.birthday();

        return this;
    }

    public String getName() {
        return name;
    }

    public String getDocument() {
        return document;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
