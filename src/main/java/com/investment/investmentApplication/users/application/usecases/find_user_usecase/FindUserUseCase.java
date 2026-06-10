package com.investment.investmentApplication.users.application.usecases.find_user_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserGateway;
import com.investment.investmentApplication.users.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindUserUseCase implements UseCase<UserId, User> {

    private final UserGateway userGateway;

    @Override
    public User execute(UserId anId) {
        final var entity = userGateway.findById(anId);
        return entity;
    }
}
