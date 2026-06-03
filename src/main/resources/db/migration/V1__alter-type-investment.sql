ALTER TABLE tb_investment
    ADD CONSTRAINT chk_investment_type
        CHECK (type IN (
                        'TESOURO_DIRETO',
                        'CDB',
                        'LCI',
                        'LCA',
                        'DEBENTURE',
                        'ACAO',
                        'FII',
                        'ETF',
                        'BDR',
                        'OPCAO',
                        'FUNDO_RENDA_FIXA',
                        'FUNDO_MULTIMERCADO',
                        'FUNDO_ACOES',
                        'CRIPTOMOEDA',
                        'PREVIDENCIA_PRIVADA'
            )
        );