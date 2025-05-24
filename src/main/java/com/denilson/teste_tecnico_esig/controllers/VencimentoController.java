package com.denilson.teste_tecnico_esig.controllers;

import com.denilson.teste_tecnico_esig.entities.Vencimento;
import com.denilson.teste_tecnico_esig.services.VencimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vencimentos")
public class VencimentoController {

    private final VencimentoService vencimentoService;

    public VencimentoController(VencimentoService vencimentoService) {
        this.vencimentoService = vencimentoService;
    }

    @GetMapping
    public ResponseEntity<List<Vencimento>> listarTodos() {
        return ResponseEntity.ok(vencimentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vencimento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(vencimentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Vencimento> salvar(@RequestBody Vencimento vencimento) {
        return ResponseEntity.ok(vencimentoService.save(vencimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Vencimento> atualizar(@PathVariable Long id, @RequestBody Vencimento vencimentoAtualizado) {
        return ResponseEntity.ok(vencimentoService.update(id, vencimentoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        vencimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}