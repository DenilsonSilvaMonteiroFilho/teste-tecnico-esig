package com.denilson.teste_tecnico_esig.repositories;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import com.denilson.teste_tecnico_esig.entities.CargoVencimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CargoVencimentoRepository extends JpaRepository<CargoVencimento, Long> {
     List<CargoVencimento> findByCargo(Cargo cargo);
}
