package com.finances.cashflow.repository;

import com.finances.cashflow.entity.Taxa;
import com.finances.cashflow.enums.TipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaxaRepository extends JpaRepository<Taxa, Long> {
    List<Taxa> findByTipoPagamento(TipoPagamento tipoPagamento);
    List<Taxa> findByTipoPagamentoAndParcelas(TipoPagamento tipoPagamento, Integer  parcelas );

}
