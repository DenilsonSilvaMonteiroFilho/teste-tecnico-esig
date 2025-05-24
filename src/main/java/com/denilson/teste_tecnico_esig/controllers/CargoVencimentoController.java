package com.denilson.teste_tecnico_esig.controllers;

import com.denilson.teste_tecnico_esig.entities.CargoVencimento;
import com.denilson.teste_tecnico_esig.services.CargoVencimentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo-vencimentos")
public class CargoVencimentoController {

    private final CargoVencimentoService cargoVencimentoService;

    public CargoVencimentoController(CargoVencimentoService cargoVencimentoService) {
        this.cargoVencimentoService = cargoVencimentoService;
    }

    @GetMapping
    public ResponseEntity<List<CargoVencimento>> listarTodos() {
        return ResponseEntity.ok(cargoVencimentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargoVencimento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cargoVencimentoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CargoVencimento> salvar(@RequestBody CargoVencimento cargoVencimento) {
        return ResponseEntity.ok(cargoVencimentoService.save(cargoVencimento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CargoVencimento> atualizar(@PathVariable Long id, @RequestBody CargoVencimento atualizado) {
        return ResponseEntity.ok(cargoVencimentoService.update(id, atualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cargoVencimentoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
