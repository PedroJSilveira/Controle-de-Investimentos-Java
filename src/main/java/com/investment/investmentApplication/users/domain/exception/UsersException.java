package com.investment.investmentApplication.users.domain.exception;

import com.investment.investmentApplication.shared.domain.exception.BusinessException;
import org.springframework.http.HttpStatus;

public class UsersException {

    public static class UserNotFoundException extends BusinessException {
        public UserNotFoundException() {
            super("User not found", HttpStatus.NOT_FOUND);
        }
    }

}
