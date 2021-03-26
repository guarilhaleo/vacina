package com.example.vacina.repository;

import com.example.vacina.model.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface VacinaRepository extends JpaRepository<Vacina, Long> {
}
