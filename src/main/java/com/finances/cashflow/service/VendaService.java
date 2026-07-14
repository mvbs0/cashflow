package com.finances.cashflow.service;

import com.finances.cashflow.entity.Venda;
import com.finances.cashflow.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendaService {

    @Autowired
    private TaxaRepository taxaRepository;

    public Venda calcularTaxas (Venda venda){

        Double credito = venda.getValorCredito() != null ? venda.getValorCredito(): 0.0 ;
        Double debito =  venda.getValorDebito() != null ? venda.getValorDebito(): 0.0 ;
        Double creditoParcelado =  venda.getValorCreditoParcelado() != null ? venda.getValorCreditoParcelado(): 0.0;
        Double pix = venda.getValorPix() != null ? venda.getValorPix() : 0.0;

        Double totalBruto = credito + debito + creditoParcelado + pix;
        venda.setTotalBruto(totalBruto);

        return venda;
    }

}


