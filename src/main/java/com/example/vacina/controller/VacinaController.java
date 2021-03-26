package com.example.vacina.controller;

import com.example.vacina.DTO.VacinaDTO;
import com.example.vacina.DTO.VacinaListDTO;
import com.example.vacina.mapper.VacinaMapper;
import com.example.vacina.model.Vacina;
import com.example.vacina.service.VacinaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/vacinas")

public class VacinaController {

    private final VacinaService vacinaService;
    private final VacinaMapper  vacinaMapper;

    public VacinaController(VacinaService vacinaService, VacinaMapper vacinaMapper) {
        this.vacinaService = vacinaService;
        this.vacinaMapper = vacinaMapper;
    }

    @GetMapping
    public ResponseEntity<VacinaListDTO> findAll() {
        List<VacinaDTO> dtos = this.vacinaService.findAll()
                .stream()
                .map(this.vacinaMapper::mapToDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(new VacinaListDTO(dtos), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacinaDTO> findById(@PathVariable Long id) {
        return new ResponseEntity<>(
                this.vacinaMapper.mapToDTO(this.vacinaService.findById(id)),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VacinaDTO> create(@RequestBody VacinaDTO dto) {
        Vacina createdVacina = this.vacinaService.create(this.vacinaMapper.mapToEntity(dto));
        return new ResponseEntity<>(this.vacinaMapper.mapToDTO(createdVacina), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacinaDTO> update(@PathVariable Long id, @RequestBody VacinaDTO dto) {
        Vacina foundVacina = this.vacinaService.findById(id);
        foundVacina.setNome(dto.getNome());
        foundVacina.setOrigem(dto.getOrigem());
        return new ResponseEntity<>(
                this.vacinaMapper.mapToDTO(this.vacinaService.update(foundVacina)),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        this.vacinaService.deleteById(id);
        return new ResponseEntity<>("Resource removed", HttpStatus.OK);
    }


}
