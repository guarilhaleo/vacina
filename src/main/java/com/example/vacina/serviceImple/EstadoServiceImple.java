package com.example.vacina.serviceImple;

import com.example.vacina.model.Estado;
import com.example.vacina.repository.EstadoRepository;
import com.example.vacina.service.EstadoService;
import org.springframework.stereotype.Service;

import  javax.persistence.EntityNotFoundException ;
@Service
public class EstadoServiceImple extends  BaseServiceImple <Estado, Long >  implements EstadoService {


    private  final EstadoRepository estadoRepository;

    public  EstadoServiceImple (  EstadoRepository estadoRepository  ) {
        super (estadoRepository);
        this.estadoRepository = estadoRepository;
    }

    @Override
    public Estado findByUF ( String  uf ) {
        return  this.estadoRepository.findBySiglaEquals(uf)
                .orElseThrow (()-> new  EntityNotFoundException (
                        String.format( " Estado com UF% s não encontrado " , uf)));
    }


}
