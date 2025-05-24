package com.denilson.teste_tecnico_esig.repositories;

import com.denilson.teste_tecnico_esig.entities.PessoaSalarioConsolidado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaSalarioConsolidadoRepository extends JpaRepository<PessoaSalarioConsolidado, Long> {
}
