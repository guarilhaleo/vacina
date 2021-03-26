package com.example.vacina.repository;

import com.example.vacina.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public  interface EstadoRepository extends JpaRepository<Estado, Long> {

    Optional<Estado> findBySiglaEquals(String sigla);
}
