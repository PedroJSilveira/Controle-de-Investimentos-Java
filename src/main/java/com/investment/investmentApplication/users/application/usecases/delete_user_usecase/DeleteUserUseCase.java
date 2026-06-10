package com.investment.investmentApplication.users.application.usecases.delete_user_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserGateway;
import com.investment.investmentApplication.users.domain.UserId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteUserUseCase implements UseCase<UserId, User> {

    private final UserGateway userGateway;

    @Override
    public User execute(UserId input) {
        final var entity = userGateway.findById(input);
        entity.disable();
        return userGateway.save(entity);
    }
}
