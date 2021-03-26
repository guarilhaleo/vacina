package com.example.vacina.DTO;

import com.sun.istack.NotNull;
import lombok.*;

@NoArgsConstructor
@Data

public class EstadoDTO {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String uf;

}
