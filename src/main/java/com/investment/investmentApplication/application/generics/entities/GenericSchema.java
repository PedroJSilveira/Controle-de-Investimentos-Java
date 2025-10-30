package com.investment.investmentApplication.application.generics.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class GenericSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@MappedSuperclass
public abstract class GenericSchema implements Serializable {

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

    public void disable(){
        this.disabled = true;
        disabledDate = LocalDateTime.now();
    }

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
