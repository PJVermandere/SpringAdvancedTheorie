package com.example.springadvancedtheorie.repositories;

import com.example.springadvancedtheorie.domain.Filiaal;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FiliaalRepository extends JpaRepository<Filiaal, Long> {
    List<Filiaal> findByGemeente(String gemeente);
}
