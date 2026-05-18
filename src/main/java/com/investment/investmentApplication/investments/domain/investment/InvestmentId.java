package com.investment.investmentApplication.investments.domain.investment;

import com.investment.investmentApplication.investments.domain.Identifier;

import java.util.Objects;
import java.util.UUID;

/**
 * The Class InvestimentId
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */
public class InvestmentId extends Identifier {

    private final UUID id;

    private InvestmentId(UUID anId) {
        this.id = anId;
    }

    public static InvestmentId unique() { return InvestmentId.from(UUID.randomUUID()); }

    public static InvestmentId from(UUID anId) {
        return new InvestmentId(anId);
    }

    @Override
    public UUID getValue() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvestmentId that = (InvestmentId) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
