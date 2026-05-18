package com.investment.investmentApplication.investments.domain.investment;

import com.investment.investmentApplication.investments.application.dto.InvestmentCreate;
import com.investment.investmentApplication.investments.application.usecases.update_investment_usecase.InvestmentUpdateCommand;
import com.investment.investmentApplication.investments.domain.Aggregate;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * The Class Investment
 *
 * @author Pedro Junho Silveira
 * @since 28/10/2025
 */

public class Investment extends Aggregate<InvestmentId> {

        private String name;

        private String type;

        private LocalDate investmentDate;

        private Double value;

        protected Investment(
                final LocalDateTime aCreatedAt,
                final LocalDateTime anUpdatedAt,
                final LocalDateTime aDisabledAt,
                final boolean aDisabled,
                final InvestmentId anId,
                final String aName,
                final String aType,
                final LocalDate anInvestmentDate,
                final Double aValue
        ) {
                super(aCreatedAt, anUpdatedAt, aDisabledAt, aDisabled, anId);
                this.name = aName;
                this.type = aType;
                this.investmentDate = anInvestmentDate;
                this.value = aValue;
        }

        public static Investment generate(InvestmentCreate anInvestmentCreate) {
                return new Investment(
                        LocalDateTime.now(),
                        LocalDateTime.now(),
                        null,
                        false,
                        InvestmentId.unique(),
                        anInvestmentCreate.name(),
                        anInvestmentCreate.type(),
                        anInvestmentCreate.investmentDate(),
                        anInvestmentCreate.value()
                );
        }

        public static Investment from(
                final LocalDateTime aCreatedAt,
                final LocalDateTime anUpdatedAt,
                final LocalDateTime aDisabledAt,
                final boolean aDisabled,
                final InvestmentId anId,
                final String aName,
                final String aType,
                final LocalDate anInvestmentDate,
                final Double aValue
        ) {
                return new Investment(
                        aCreatedAt,
                        anUpdatedAt,
                        aDisabledAt,
                        aDisabled,
                        anId,
                        aName,
                        aType,
                        anInvestmentDate,
                        aValue
                );
        }

        public Investment update(InvestmentUpdateCommand anInvestment){
            this.name = anInvestment.name();
            this.type = anInvestment.type();
            this.investmentDate = anInvestment.date();
            this.value = anInvestment.value();
            this.updatedAt = LocalDateTime.now();

            return this;
        }

        public void disable() {
            this.disabledAt = LocalDateTime.now();
            this.disabled = true;
        }

        public String getName() {
                return name;
        }

        public String getType() {
                return type;
        }

        public LocalDate getInvestmentDate() {
                return investmentDate;
        }

        public Double getValue() {
                return value;
        }
}
