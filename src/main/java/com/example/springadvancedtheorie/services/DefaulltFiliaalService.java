package com.example.springadvancedtheorie.services;

import com.example.springadvancedtheorie.domain.Filiaal;
import com.example.springadvancedtheorie.exceptions.FilaalNietGevondenException;
import com.example.springadvancedtheorie.repositories.FiliaalRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class DefaulltFiliaalService implements FiliaalService {
    private final FiliaalRepository repository;

    public DefaulltFiliaalService(FiliaalRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Filiaal> findById(long id) {

        return repository.findById(id);
    }

    @Override
    public List<Filiaal> findAll() {
        return repository.findAll();
    }


    @Override
    public void update(Filiaal filiaal) {
        repository.save(filiaal);
    }

    @Override
    public void create(Filiaal filiaal) {
        repository.save(filiaal);

    }

    @Override
    public void delete(long id) {
        try{
            repository.deleteById(id);
        }
        catch (Exception e){
            throw new FilaalNietGevondenException();
        };
    }
}
