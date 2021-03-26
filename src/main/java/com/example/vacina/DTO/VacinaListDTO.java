package com.example.vacina.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data

public class VacinaListDTO {
    private List<VacinaDTO> data;
    private int total;

    public VacinaListDTO(List<VacinaDTO> data) {
        this.data = data;
        this.total = data.size();
    }
}
