package com.example.springadvancedtheorie.services;

import com.example.springadvancedtheorie.domain.Lid;
import com.example.springadvancedtheorie.mailing.Mailer;
import com.example.springadvancedtheorie.repositories.LedenRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
    public void nieuweInschrijving(Lid lid, String url) {
        repository.save(lid);
        mailer.bevestigingsMail(lid, url);
    }
}
