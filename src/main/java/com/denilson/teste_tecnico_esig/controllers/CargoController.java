package com.denilson.teste_tecnico_esig.controllers;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.services.CargoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargos")
public class CargoController {

    private final CargoService cargoService;

    public CargoController(CargoService cargoService) {
        this.cargoService = cargoService;
    }

    @GetMapping
    public ResponseEntity<List<Cargo>> listarTodos() {
        return ResponseEntity.ok(cargoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cargo> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cargoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cargo> salvar(@RequestBody Cargo cargo) {
        return ResponseEntity.ok(cargoService.save(cargo));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cargo> atualizar(@PathVariable Long id, @RequestBody Cargo cargoAtualizado) {
        return ResponseEntity.ok(cargoService.update(id, cargoAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        cargoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
