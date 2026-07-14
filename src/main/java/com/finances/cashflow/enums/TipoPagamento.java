package com.finances.cashflow.enums;

public enum TipoPagamento {
    //criar funçao para taxa fixa de 15% para todos os metodos

    CREDITO(0.15),
    DEBITO(0.15),
    PIX(0.15);
    //Atributo
    private final double taxaFixa;
    //Construtor
    TipoPagamento(double taxaFixa) {
        this.taxaFixa = taxaFixa;
    }

    //getter


    public double getTaxaFixa() {
        return taxaFixa;
    }
}
