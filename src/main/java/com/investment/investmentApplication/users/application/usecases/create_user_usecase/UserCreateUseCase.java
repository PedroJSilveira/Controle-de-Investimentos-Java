package com.investment.investmentApplication.users.application.usecases.create_user_usecase;

import com.investment.investmentApplication.shared.application.usecases.UseCase;
import com.investment.investmentApplication.users.application.dtos.UserCreate;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserCreateUseCase implements UseCase<UserCreate, User> {

    private final UserGateway userGateway;

    private final PasswordEncoder passwordEncoder;

    @Override
    public User execute(UserCreate anInput) {
        String password = passwordEncoder.encode(anInput.password());

        final var entity = User.generate(anInput, password);

        return userGateway.save(entity);
    }

}
