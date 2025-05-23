package com.denilson.teste_tecnico_esig.repositories;

import com.denilson.teste_tecnico_esig.entities.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Long, Cargo> {

}
