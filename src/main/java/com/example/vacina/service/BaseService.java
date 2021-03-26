package com.example.vacina.service;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public interface BaseService<T, ID> {

    List<T> findAll();

    List<T> findAll(Sort sort);

    T findById(ID id);

    T create(T t);

    T update(T t);

    void delete(T t);

    void deleteById(ID id);
}
