package com.investment.investmentApplication.shared.domain;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Class Aggregate
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */

public abstract class Aggregate<ID extends Identifier> extends Auditing {

    protected final ID id;

    protected Aggregate(
            final LocalDateTime aCreatedAt,
            final LocalDateTime anUpdatedAt,
            final LocalDateTime aDisabledAt,
            final boolean aDisabled,
            final ID anId
    ) {
        super(
                aCreatedAt,
                anUpdatedAt,
                aDisabledAt,
                aDisabled
        );
        this.id = anId;
    }

    public void disable() {
        this.disabledAt = LocalDateTime.now();
        this.disabled = true;
    }

    protected Aggregate(final ID anId) {
        this.id = anId;
    }

    public ID getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        final Aggregate<?> aggregate = (Aggregate<?>) o;
        return Objects.equals(getId(), aggregate.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
