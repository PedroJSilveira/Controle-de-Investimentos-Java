package com.investment.investmentApplication.users.infraestructure.api.user;

import com.investment.investmentApplication.users.application.dtos.UserCreate;
import com.investment.investmentApplication.users.application.dtos.UserUpdate;
import com.investment.investmentApplication.users.application.usecases.create_user_usecase.UserCreateUseCase;
import com.investment.investmentApplication.users.application.usecases.delete_user_usecase.DeleteUserUseCase;
import com.investment.investmentApplication.users.application.usecases.find_user_usecase.FindUserUseCase;
import com.investment.investmentApplication.users.application.usecases.update_user_usecase.UpdateUserUseCase;
import com.investment.investmentApplication.users.application.usecases.update_user_usecase.UserUpdateCommand;
import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserId;
import com.investment.investmentApplication.users.infraestructure.api.user.Interfaces.UserController;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserCreateUseCase userCreateUseCase;

    private final FindUserUseCase findUserUseCase;

    private final UpdateUserUseCase updateUserUseCase;

    private final DeleteUserUseCase deleteUserUseCase;

    @Override
    public ResponseEntity<User> create(UserCreate user) {
        final var entity = userCreateUseCase.execute(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @Override
    public ResponseEntity<User> findById(UUID anId) {
        final var entity = findUserUseCase.execute(UserId.from(anId));
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @Override
    public ResponseEntity<User> update(UUID anId, UserUpdate user) {
        final var entity = updateUserUseCase.execute(UserUpdateCommand.converter(UserId.from(anId), user));
        return ResponseEntity.status(HttpStatus.OK).body(entity);
    }

    @Override
    public ResponseEntity<Void> delete(UUID anId) {
        deleteUserUseCase.execute(UserId.from(anId));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
