package com.shtramak.legostore.service;

import com.shtramak.legostore.model.LegoSet;
import org.springframework.context.annotation.Profile;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile({"mongo-template"})
public class LegoSetServiceMongoTemplate implements LegoSetService {
    private final MongoTemplate mongoTemplate;

    public LegoSetServiceMongoTemplate(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void insert(LegoSet legoSet) {
        mongoTemplate.insert(legoSet);
    }

    @Override
    public List<LegoSet> findAll() {
        return mongoTemplate.findAll(LegoSet.class);
    }

    @Override
    public void update(LegoSet legoSet) {
        mongoTemplate.save(legoSet);
    }

    @Override
    public void delete(String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), LegoSet.class);
    }
}
