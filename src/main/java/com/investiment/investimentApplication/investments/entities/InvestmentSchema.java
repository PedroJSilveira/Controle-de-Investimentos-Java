package com.investiment.investimentApplication.investments.entities;

import com.investiment.investimentApplication.application.generics.entities.GenericSchema;
import com.investiment.investimentApplication.investments.dtos.Investment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * The Class InvestmentSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@Entity
@Table(name = "investiment_schema")
public class InvestmentSchema extends GenericSchema {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "investment_date")
    private LocalDate investmentDate;

    @Column(name = "value")
    private Double value;

    public InvestmentSchema() {
    }

    private InvestmentSchema(String name, String type, LocalDate investmentDate, Double value) {
        this.name = name;
        this.type = type;
        this.investmentDate = investmentDate;
        this.value = value;
    }

    public InvestmentSchema generate(Investment investment){
        return new InvestmentSchema(
                investment.name(),
                investment.type(),
                investment.investmentDate(),
                investment.value()
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDate getInvestmentDate() {
        return investmentDate;
    }

    public void setInvestmentDate(LocalDate investmentDate) {
        this.investmentDate = investmentDate;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InvestmentSchema that = (InvestmentSchema) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(type, that.type) &&
                Objects.equals(investmentDate, that.investmentDate) &&
                Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, type, investmentDate, value);
    }
}
