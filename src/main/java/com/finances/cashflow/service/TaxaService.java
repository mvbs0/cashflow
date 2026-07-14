package com.finances.cashflow.service;

import com.finances.cashflow.dto.TaxaDTO;
import com.finances.cashflow.entity.Taxa;
import com.finances.cashflow.enums.TipoPagamento;
import com.finances.cashflow.repository.TaxaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TaxaService {
    @Autowired
    private TaxaRepository taxaRepository;

    public Taxa criar(TaxaDTO dto){

        //Regra de negocio: crédito precisa informar parcelas
        if (dto.getTipoPagamento() == TipoPagamento.CREDITO
                && dto.getParcelas() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Numero de parcelas inválido");
        }

        if(dto.getTaxaVariavel() < 0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Taxa menor que 0, opçao invalida");
        }


        // Converte DTO para Entity
        Taxa taxa = new Taxa();
        taxa.setTipoPagamento(dto.getTipoPagamento());
        taxa.setParcelas(dto.getParcelas());
        taxa.setTaxaFixa(dto.getTaxaFixa());
        taxa.setTaxaVariavel(dto.getTaxaVariavel());

        return taxaRepository.save(taxa);
    }
    // Busca todas as taxas
    public List<Taxa> listarTodas(){
        return taxaRepository.findAll();

    }

    //Busca por id

    public Taxa buscarPorId(Long id) {
        return taxaRepository.findById(id).orElseThrow(() -> new RuntimeException("Taxa não enontrada com id: " + id));

    }
    public Taxa atualizar (Long id, TaxaDTO dto){
        //buscar no no banco
        Taxa taxa = buscarPorId(id);

        //converter dto para entity
        taxa.setTipoPagamento(dto.getTipoPagamento());
        taxa.setParcelas(dto.getParcelas());
        taxa.setTaxaFixa(dto.getTaxaFixa());
        taxa.setTaxaVariavel(dto.getTaxaVariavel());

        return taxaRepository.save(taxa);
    }
    public void deletar (Long id){
        Taxa taxa = buscarPorId(id);
        taxaRepository.deleteById(id);

    }
}
