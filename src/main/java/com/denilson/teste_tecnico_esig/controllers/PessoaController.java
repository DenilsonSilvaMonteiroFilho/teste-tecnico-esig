package com.denilson.teste_tecnico_esig.controllers;

import com.denilson.teste_tecnico_esig.entities.Pessoa;
import com.denilson.teste_tecnico_esig.services.PessoaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listarTodas() {
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(pessoaService.save(pessoa));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoaAtualizada) {
        return ResponseEntity.ok(pessoaService.update(id, pessoaAtualizada));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
