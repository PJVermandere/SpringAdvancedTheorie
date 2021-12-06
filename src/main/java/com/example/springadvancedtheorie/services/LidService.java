package com.example.springadvancedtheorie.services;

import com.example.springadvancedtheorie.domain.Lid;

import java.util.Optional;

public interface LidService {
    Optional<Lid> findById(long id);
    void nieuweInschrijving(Lid lid, String url);
}
