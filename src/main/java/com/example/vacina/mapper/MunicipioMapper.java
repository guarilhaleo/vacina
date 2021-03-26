package com.example.vacina.mapper;

import com.example.vacina.DTO.CreateMunicipioDTO;
import com.example.vacina.DTO.MunicipioDTO;
import com.example.vacina.model.Municipio;
import com.example.vacina.service.EstadoService;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component

public class MunicipioMapper {
    private final EstadoService estadoService;

    public MunicipioMapper(EstadoService estadoService) {
        this.estadoService = estadoService;
    }

    public Municipio mapToEntity( CreateMunicipioDTO dto) {
        Municipio municipio = new Municipio();

        if (dto.getUf() != null) {
            municipio.setEstado(this.estadoService.findByUF(dto.getUf()));
        }

        municipio.setNome(dto.getNome());

        return municipio;
    }

    public MunicipioDTO mapToDTO( Municipio entity) {
        MunicipioDTO dto = new MunicipioDTO();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());

        if (entity.getEstado() != null) {
            dto.setUf(entity.getEstado().getSigla());
        }

        return dto;
    }

}
