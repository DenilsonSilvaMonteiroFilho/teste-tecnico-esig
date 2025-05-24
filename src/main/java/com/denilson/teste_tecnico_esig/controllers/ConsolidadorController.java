package com.denilson.teste_tecnico_esig.controllers;

import com.denilson.teste_tecnico_esig.entities.PessoaSalarioConsolidado;
import com.denilson.teste_tecnico_esig.services.ConsolidadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/consolidar")
public class ConsolidadorController {
    @Autowired
    ConsolidadorService consolidadorService;

    @PostMapping("/salarios")
    public ResponseEntity<List<PessoaSalarioConsolidado>> consolidarSalarios(){
        return ResponseEntity.ok(consolidadorService.consolidarCargoVencimento());
    }
}
