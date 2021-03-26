package com.example.vacina.serviceImple;

import com.example.vacina.model.Municipio;
import com.example.vacina.repository.MunicipioRepository;
import com.example.vacina.service.MunicipioService;
import org.springframework.stereotype.Service;


@Service
public class MunicipioServiceImple extends BaseServiceImple<Municipio, Long> implements MunicipioService {
    public MunicipioServiceImple( MunicipioRepository repository) {
        super(repository);
    }
}
