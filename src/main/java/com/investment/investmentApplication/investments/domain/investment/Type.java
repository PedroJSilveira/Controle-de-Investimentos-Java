package com.investment.investmentApplication.investments.domain.investment;

import org.hibernate.annotations.Comment;

public enum Type {

    @Comment("Renda Fixa")
    TESOURO_DIRETO("Tesouro Direto"),
    CDB("CDB"),
    LCI("LCI"),
    LCA("LCA"),
    DEBENTURE("Debênture"),

    @Comment("Renda Variável")
    ACAO("Ação"),
    FII("FII"),
    ETF("ETF"),
    BDR("BDR"),
    OPCAO("Opção"),

    @Comment("Fundos")
    FUNDO_RENDA_FIXA("Fundo de Renda Fixa"),
    FUNDO_MULTIMERCADO("Fundo Multimercado"),
    FUNDO_ACOES("Fundo de Ações"),

    @Comment("Outros")
    CRIPTOMOEDA("Criptomoeda"),
    PREVIDENCIA_PRIVADA("Previdência Privada");

    private final String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
