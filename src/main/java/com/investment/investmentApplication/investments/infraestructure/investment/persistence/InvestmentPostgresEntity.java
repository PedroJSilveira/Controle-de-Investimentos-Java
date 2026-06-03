package com.investment.investmentApplication.investments.infraestructure.investment.persistence;

import com.investment.investmentApplication.investments.domain.investment.Investment;
import com.investment.investmentApplication.investments.domain.investment.InvestmentId;
import com.investment.investmentApplication.investments.domain.investment.Type;
import com.investment.investmentApplication.investments.infraestructure.shared.persistence.BasePostgresEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * The Class InvestmentSchema
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

@Entity(name = "Investment")
@Table(name = "tb_investment")
public class InvestmentPostgresEntity extends BasePostgresEntity {

    @Id
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private Type type;

    @Column(name = "investment_date")
    private LocalDate investmentDate;

    @Column(name = "value")
    private Double value;

    public InvestmentPostgresEntity() {
    }

    private InvestmentPostgresEntity(
            LocalDateTime aCreatedAt,
            LocalDateTime anUpdatedAt,
            boolean aDisabled,
            LocalDateTime aDisabledAt,
            UUID anId,
            String aName,
            Type aType,
            LocalDate anInvestmentDate,
            Double aValue
    ) {
        super(aCreatedAt, anUpdatedAt, aDisabled, aDisabledAt);
        this.id = anId;
        this.name = aName;
        this.type = aType;
        this.investmentDate = anInvestmentDate;
        this.value = aValue;
    }

    public static InvestmentPostgresEntity from(Investment anInvestment) {
        return new InvestmentPostgresEntity(
                anInvestment.getCreatedAt(),
                anInvestment.getUpdatedAt(),
                anInvestment.isDisabled(),
                anInvestment.getDisabledAt(),
                anInvestment.getId().getValue(),
                anInvestment.getName(),
                anInvestment.getType(),
                anInvestment.getInvestmentDate(),
                anInvestment.getValue()
        );
    }

    public Investment toDomain() {
        return Investment.from(
                getCreatedDate(),
                getUpdatedDate(),
                getDisabledDate(),
                isDisabled(),
                InvestmentId.from(getId()),
                getName(),
                getType(),
                getInvestmentDate(),
                getValue()
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

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
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
        InvestmentPostgresEntity that = (InvestmentPostgresEntity) o;
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
