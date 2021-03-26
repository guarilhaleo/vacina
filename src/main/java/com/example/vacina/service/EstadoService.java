package com.example.vacina.service;

import com.example.vacina.model.Estado;
import org.springframework.stereotype.Service;

@Service
public interface EstadoService extends  BaseService<Estado, Long> {

    Estado findByUF( String uf);
}
