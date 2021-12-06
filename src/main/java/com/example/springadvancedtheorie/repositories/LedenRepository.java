package com.example.springadvancedtheorie.repositories;

import com.example.springadvancedtheorie.domain.Lid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LedenRepository extends JpaRepository<Lid, Long> {
}
