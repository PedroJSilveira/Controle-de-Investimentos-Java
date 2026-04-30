package com.investment.investmentApplication.investments.domain.shared;

import jakarta.persistence.Column;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

/**
 * The Class BaseEntity
 *
 * @author Pedro Junho Silveira
 * @since 30/04/2026
 */

public class BaseEntity {

    private LocalDateTime createdDate = LocalDateTime.now();

    private LocalDateTime updatedDate;

    private boolean disabled = false;

    private LocalDateTime disabledDate;

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDateTime getDisabledDate() {
        return disabledDate;
    }

    public void setDisabledDate(LocalDateTime disabledDate) {
        this.disabledDate = disabledDate;
    }
}
