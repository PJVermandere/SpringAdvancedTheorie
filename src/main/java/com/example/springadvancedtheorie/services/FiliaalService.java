package com.example.springadvancedtheorie.services;

import com.example.springadvancedtheorie.domain.Filiaal;

import java.util.List;
import java.util.Optional;

public interface FiliaalService {
    List<Filiaal> findAll();
    Optional<Filiaal> findById(long id);
    void update(Filiaal filiaal);
    void create(Filiaal filiaal);
    void delete(long id);
}
