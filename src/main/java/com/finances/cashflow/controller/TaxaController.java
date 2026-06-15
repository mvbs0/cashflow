package com.finances.cashflow.controller;

import com.finances.cashflow.dto.TaxaDTO;
import com.finances.cashflow.entity.Taxa;
import com.finances.cashflow.service.TaxaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/taxas")
public class TaxaController {

    @Autowired
    private TaxaService taxaService;

    @PostMapping
    public ResponseEntity<Taxa> criar(@RequestBody TaxaDTO dto) {
        Taxa salva = taxaService.criar(dto);
        return ResponseEntity.ok(salva);
    }
    @GetMapping
    public ResponseEntity<List<Taxa>> listarTodas() {
        List<Taxa> taxas = taxaService.listarTodas();
        return ResponseEntity.ok(taxas);
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Taxa> buscarPorId(@PathVariable Long id) {
        Taxa taxa = taxaService.buscarPorId(id);
        return ResponseEntity.ok(taxa);
    }
}
