package com.example.vacina.model;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Data



public class Municipio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    private Estado estado;


}
