package com.example.vacina.serviceImple;

import com.example.vacina.model.Vacina;
import com.example.vacina.repository.VacinaRepository;
import com.example.vacina.service.VacinaService;
import org.springframework.stereotype.Service;


@Service
public class VacinaServiceImpl extends BaseServiceImple<Vacina, Long> implements VacinaService {
    public VacinaServiceImpl( VacinaRepository repository) {
        super(repository);
    }
}
