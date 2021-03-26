package com.example.vacina.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Data
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "sigla", unique = true)
    private String sigla;

    @OneToMany(mappedBy = "estado")
    private List<Municipio> municipios;
}
