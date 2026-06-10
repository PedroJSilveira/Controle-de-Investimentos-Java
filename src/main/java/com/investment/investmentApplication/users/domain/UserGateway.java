package com.investment.investmentApplication.users.domain;

import org.springframework.stereotype.Component;

@Component
public interface UserGateway {

    User save(User anInput);

    User findById(UserId anId);
}
