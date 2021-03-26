package com.example.vacina.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Table (name = "vacina")
@Data
public class Vacina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String origem;
}
