package com.example.vacina.repository;

import com.example.vacina.model.Municipio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface MunicipioRepository extends JpaRepository<Municipio, Long>{

}
