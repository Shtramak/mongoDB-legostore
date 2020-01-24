package com.shtramak.legostore.service;

import com.shtramak.legostore.model.LegoSet;
import com.shtramak.legostore.repository.LegoSetMongoRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"default", "mongo-repository"})
public class LegoSetServiceMongoRepository implements LegoSetService {
    private final LegoSetMongoRepository repository;

    public LegoSetServiceMongoRepository(LegoSetMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void insert(LegoSet legoSet) {
        repository.insert(legoSet);
    }

    @Override
    public List<LegoSet> findAll() {
        return repository.findAll();
    }

    @Override
    public void update(LegoSet legoSet) {
        repository.save(legoSet);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}
