package com.denilson.teste_tecnico_esig.repositories;

import com.denilson.teste_tecnico_esig.entities.CargoVencimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoVencimentoRepository extends JpaRepository<CargoVencimento, Long> {
}
