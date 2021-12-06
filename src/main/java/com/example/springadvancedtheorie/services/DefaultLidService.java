package com.example.springadvancedtheorie.services;

import com.example.springadvancedtheorie.domain.Lid;
import com.example.springadvancedtheorie.mailing.Mailer;
import com.example.springadvancedtheorie.repositories.LedenRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

@Service
@Transactional
public class DefaultLidService implements LidService {
    private final LedenRepository repository;
    private final Mailer mailer;
    public DefaultLidService(LedenRepository repository, Mailer mailer) {
        this.repository = repository;
        this.mailer = mailer;
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Lid> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void nieuweInschrijving(Lid lid, String url) {
        repository.save(lid);
        mailer.bevestigingsMail(lid, url);
    }
}
