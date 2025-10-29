package com.investment.investmentApplication.application.generics.entities;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDate;

/**
 * The Class GenericSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@MappedSuperclass
public class GenericSchema {

    @Column(name = "created_date")
    @CreatedDate
    private LocalDate created_date = LocalDate.now();

    @Column(name = "updated_date")
    @LastModifiedDate
    private LocalDate updated_date;

    @Column(name = "disabled")
    private boolean disabled = false;

    @Column(name = "disabled_date")
    private LocalDate disabled_date;

    public void disable(){
        this.disabled = true;
        disabled_date = LocalDate.now();
    }

    public void reactivate(){
        this.disabled = false;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public LocalDate getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(LocalDate updated_date) {
        this.updated_date = updated_date;
    }

    public boolean isDisabled() {
        return disabled;
    }

    public void setDisabled(boolean disabled) {
        this.disabled = disabled;
    }

    public LocalDate getDisabled_date() {
        return disabled_date;
    }

    public void setDisabled_date(LocalDate disabled_date) {
        this.disabled_date = disabled_date;
    }
}
