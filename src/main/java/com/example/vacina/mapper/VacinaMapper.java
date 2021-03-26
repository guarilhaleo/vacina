package com.example.vacina.mapper;

import com.example.vacina.DTO.VacinaDTO;
import com.example.vacina.model.Vacina;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component

public class VacinaMapper {
    private final ModelMapper modelMapper;

    public VacinaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public VacinaDTO mapToDTO( Vacina entity) {
        return this.modelMapper.map(entity, VacinaDTO.class);
    }

    public Vacina mapToEntity(VacinaDTO dto) {
        return this.modelMapper.map(dto, Vacina.class);
    }
}
