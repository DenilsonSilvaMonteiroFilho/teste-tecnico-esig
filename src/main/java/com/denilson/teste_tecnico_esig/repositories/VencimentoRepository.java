package com.denilson.teste_tecnico_esig.repositories;

import com.denilson.teste_tecnico_esig.entities.Vencimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VencimentoRepository extends JpaRepository<Vencimento, Long> {

}
