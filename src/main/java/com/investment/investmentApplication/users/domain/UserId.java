package com.investment.investmentApplication.users.domain;

import com.investment.investmentApplication.shared.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

public class UserId extends Identifier {

    private final UUID id;

    private UserId(UUID anId) {
        this.id = anId;
    }

    public static UserId unique() { return UserId.from(UUID.randomUUID()); }

    public static UserId from(UUID anId) {
        return new UserId(anId);
    }

    @Override
    public UUID getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserId userId = (UserId) o;
        return Objects.equals(id, userId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
