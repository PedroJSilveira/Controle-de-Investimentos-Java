package com.investment.investmentApplication.investments.domain;

import java.time.LocalDateTime;

/**
 * The Class Auditing
 *
 * @author Pedro Junho Silveira
 * @since 02/05/2026
 */

public abstract class Auditing {

    protected LocalDateTime createdAt;

    protected LocalDateTime updatedAt;

    protected LocalDateTime disabledAt;

    protected boolean disabled;

    protected Auditing() {
    }

    protected Auditing(
            final LocalDateTime aCreatedAt,
            final LocalDateTime anUpdatedAt,
            final LocalDateTime aDisabledAt,
            final boolean aDisabled
    ) {
        this.createdAt = aCreatedAt;
        this.updatedAt = anUpdatedAt;
        this.disabledAt = aDisabledAt;
        this.disabled = aDisabled;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public LocalDateTime getDisabledAt() {
        return disabledAt;
    }

    public boolean isDisabled() {
        return disabled;
    }

}

