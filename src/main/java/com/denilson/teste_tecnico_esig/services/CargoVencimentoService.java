package com.denilson.teste_tecnico_esig.services;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.entities.CargoVencimento;
import com.denilson.teste_tecnico_esig.repositories.CargoVencimentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargoVencimentoService {

    private final CargoVencimentoRepository cargoVencimentoRepository;

    public CargoVencimentoService(CargoVencimentoRepository cargoVencimentoRepository) {
        this.cargoVencimentoRepository = cargoVencimentoRepository;
    }

    public List<CargoVencimento> findAll() {
        return cargoVencimentoRepository.findAll();
    }

    public CargoVencimento findById(Long id) {
        return cargoVencimentoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("CargoVencimento não encontrado com id: " + id));
    }

    public CargoVencimento save(CargoVencimento cargoVencimento) {
        return cargoVencimentoRepository.save(cargoVencimento);
    }

    public CargoVencimento update(Long id, CargoVencimento atualizado) {
        CargoVencimento existente = findById(id);
        existente.setCargo(atualizado.getCargo());
        existente.setVencimento(atualizado.getVencimento());
        return cargoVencimentoRepository.save(existente);
    }

    public void delete(Long id) {
        cargoVencimentoRepository.deleteById(id);
    }

    public List<CargoVencimento> findByCargo(Cargo cargo) {
        return cargoVencimentoRepository.findByCargo(cargo);
    }

    public List<CargoVencimento> encontrarCargoVencimentosPorCargo(List<CargoVencimento> cargoVencimentoList,
                                                                   Cargo cargo){
        List<CargoVencimento> cargoVencimentosPorCargo = new ArrayList<>();
        if(cargoVencimentoList!=null&&cargo!=null) {
            for (CargoVencimento cargoVencimento : cargoVencimentoList) {
                if (cargoVencimento.getCargo().equals(cargo)) {
                    cargoVencimentosPorCargo.add(cargoVencimento);
                }
            }
        }
        return cargoVencimentosPorCargo;
    }
}
