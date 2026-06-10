package com.investment.investmentApplication.users.infraestructure;

import com.investment.investmentApplication.users.domain.User;
import com.investment.investmentApplication.users.domain.UserGateway;
import com.investment.investmentApplication.users.domain.UserId;
import com.investment.investmentApplication.users.infraestructure.persistence.UserPostgresEntity;
import com.investment.investmentApplication.users.infraestructure.persistence.UserPostgresRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.investment.investmentApplication.users.domain.exception.UsersException.UserNotFoundException;

@Repository
@RequiredArgsConstructor
public class UserPostgresDBGateway implements UserGateway {

    private final UserPostgresRepository repository;

    @Override
    public User save(User anInput) {
        final var entity = UserPostgresEntity.from(anInput);
        return repository.save(entity).toDomain();
    }

    @Override
    public User findById(UserId anId) {
        final var entity = repository.findById(anId.getValue()).orElseThrow(UserNotFoundException::new);
        return entity.toDomain();
    }

}
