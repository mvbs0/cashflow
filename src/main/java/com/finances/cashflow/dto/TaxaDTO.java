package com.finances.cashflow.dto;

import com.finances.cashflow.enums.TipoPagamento;
import lombok.Data;

@Data
public class TaxaDTO {
    private TipoPagamento tipoPagamento;
    private Integer parcelas;
    private Double taxaFixa;
    private Double taxaVariavel;
}

