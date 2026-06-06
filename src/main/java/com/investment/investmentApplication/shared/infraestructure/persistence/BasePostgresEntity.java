package com.investment.investmentApplication.shared.infraestructure.persistence;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * The Class GenericSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@MappedSuperclass
public abstract class BasePostgresEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -3771367461195984435L;

    @Column(name = "created_date")
    @CreatedDate
    private LocalDateTime createdDate = LocalDateTime.now();

    @Column(name = "updated_date")
    @LastModifiedDate
    private LocalDateTime updatedDate;

    @Column(name = "disabled")
    private boolean disabled = false;

    @Column(name = "disabled_date")
    private LocalDateTime disabledDate;

    public BasePostgresEntity() {}

    public BasePostgresEntity(
            LocalDateTime createdDate,
            LocalDateTime updatedDate,
            boolean disabled,
            LocalDateTime disabledDate
    ) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.disabled = disabled;
        this.disabledDate = disabledDate;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public LocalDateTime getDisabledDate() {
        return disabledDate;
    }
}
