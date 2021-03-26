package com.example.vacina.controller;

import com.example.vacina.DTO.EstadoDTO;
import com.example.vacina.mapper.EstadoMapper;
import com.example.vacina.model.Estado;
import com.example.vacina.service.EstadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
// definir como defaut
@RequestMapping("/api/estados")

public class EstadoController {

    private final EstadoService estadoService;
    private final EstadoMapper  estadoMapper; // converter dto para entidade (vice e verso)

    public EstadoController(EstadoService estadoService, EstadoMapper estadoMapper) {
        this.estadoService = estadoService;
        this.estadoMapper = estadoMapper;
    }

    @GetMapping                             // findall retorna a lista do Estado DTO
    public ResponseEntity<List<EstadoDTO>> findAll() {
        List<EstadoDTO> estados = this.estadoService.findAll()
                .stream()
                .map(this.estadoMapper::convertToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(estados, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstadoDTO> findById(@PathVariable Long id) {
        Estado estado = this.estadoService.findById(id);
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(estado), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EstadoDTO> create(@RequestBody EstadoDTO dto) {
        Estado createdEstado = this.estadoService.create(this.estadoMapper.convertToEntity(dto));
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(createdEstado), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstadoDTO> update(@PathVariable Long id, @RequestBody EstadoDTO dto) {
        Estado estado = this.estadoService.findById(id);
        estado.setNome(dto.getNome());
        estado.setSigla(dto.getUf());
        return new ResponseEntity<>(this.estadoMapper.convertToDTO(this.estadoService.update(estado)), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.estadoService.deleteById(id);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }


}
