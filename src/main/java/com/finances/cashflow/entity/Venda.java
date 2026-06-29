package com.finances.cashflow.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "vendas")

public class Venda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_transacao", nullable = false)
    private LocalDateTime dataTransacao;

    @Column(name = "valor_credito", nullable = true)
    private Double valorCredito;

    @Column(name = "valor_credito_parcelado", nullable  = true)
    private Double valorCreditoParcelado;

    @Column(name = "quantidade_parcelas", nullable = true)
    private Integer quantidadeParcelas;

    @Column(name = "valor_debito", nullable = true)
    private Double valorDebito;

    @Column(name = "valor_pix", nullable = true)
    private Double valorPix;

    @Column(name = "valor_dinheiro", nullable = true)
    private Double valorDinheiro;

    @Column(name = "total_bruto", nullable = false)
    private Double totalBruto;

    @Column(name = "total_taxa",nullable = false)
    private Double totalTaxa;

    @Column(name = "total_liquido", nullable = false)
    private Double totalLiquido;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

}
