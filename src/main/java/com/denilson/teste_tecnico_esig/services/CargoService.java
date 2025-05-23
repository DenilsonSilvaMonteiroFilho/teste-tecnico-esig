package com.denilson.teste_tecnico_esig.services;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.repositories.CargoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    private final CargoRepository cargoRepository;

    public CargoService(CargoRepository cargoRepository) {
        this.cargoRepository = cargoRepository;
    }

    public List<Cargo> findAll() {
        return cargoRepository.findAll();
    }

    public Cargo findById(Long id) {
        return cargoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Cargo não encontrado com id: " + id));
    }

    public Cargo save(Cargo cargo) {
        return cargoRepository.save(cargo);
    }

    public Cargo update(Long id, Cargo cargoAtualizado) {
        Cargo cargoExistente = findById(id);
        cargoExistente.setNome(cargoAtualizado.getNome());
        return cargoRepository.save(cargoExistente);
    }

    public void delete(Long id) {
        cargoRepository.deleteById(id);
    }
}
