package com.example.vacina.mapper;

import com.example.vacina.DTO.EstadoDTO;
import com.example.vacina.model.Estado;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component

public class EstadoMapper {


    private final ModelMapper mapper;

    @Autowired
    public EstadoMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public EstadoDTO convertToDTO( Estado entity) {
        return this.mapper
                .typeMap(Estado.class, EstadoDTO.class)
                .addMapping(Estado::getSigla, EstadoDTO::setUf)
                .map(entity);
    }

    public Estado convertToEntity(EstadoDTO dto) {
        return this.mapper
                .typeMap(EstadoDTO.class, Estado.class)
                .addMapping(EstadoDTO::getUf, Estado::setSigla)
                .map(dto);
    }

}
