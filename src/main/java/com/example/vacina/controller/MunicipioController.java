package com.example.vacina.controller;

import com.example.vacina.DTO.CreateMunicipioDTO;
import com.example.vacina.DTO.MunicipioDTO;
import com.example.vacina.mapper.MunicipioMapper;
import com.example.vacina.model.Municipio;
import com.example.vacina.service.MunicipioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/municipios")

public class MunicipioController {

    private final MunicipioService municipioService;
    private final MunicipioMapper  municipioMapper;

    public MunicipioController(
            MunicipioService municipioService,
            MunicipioMapper municipioMapper) {
        this.municipioService = municipioService;
        this.municipioMapper = municipioMapper;
    }

    @PostMapping
    public ResponseEntity<MunicipioDTO> create( @RequestBody CreateMunicipioDTO dto) {
        Municipio municipio = this.municipioService.create(
                this.municipioMapper.mapToEntity(dto)
        );
        return new ResponseEntity<>(this.municipioMapper.mapToDTO(municipio), HttpStatus.CREATED);
    }
}
