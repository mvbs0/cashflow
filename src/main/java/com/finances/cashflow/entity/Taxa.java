package com.finances.cashflow.entity;

import com.finances.cashflow.enums.TipoPagamento;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "taxas")
public class Taxa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated
    @Column(name = "tipo_pagamento",nullable = false)
    private TipoPagamento tipoPagamento;

    @Column
    private Integer parcelas;

    @Column(name = "taxa_fixa", nullable = false)
    private Double taxaFixa;

    @Column(name = "taxa_variavel", nullable = false)
    private Double taxaVariavel;


}
