package com.investment.investmentApplication.users.application.usecases.update_user_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUserUseCase implements UseCase<UserUpdateCommand, User> {

    private final UserGateway userGateway;

    @Override
    public User execute(UserUpdateCommand anInput) {
        final var entity = userGateway.findById(anInput.id());
        final var entityToSave = entity.update(anInput);
        return userGateway.save(entityToSave);
    }

}
