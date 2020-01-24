package com.shtramak.legostore.model.controller;

import com.shtramak.legostore.model.LegoSet;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/legosets")
public class LegoSetController {
    private final MongoTemplate mongoTemplate;

    public LegoSetController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostMapping
    public void insert(@RequestBody LegoSet legoSet) {
        mongoTemplate.insert(legoSet);
    }

    @GetMapping
    public List<LegoSet> findAll() {
        return mongoTemplate.findAll(LegoSet.class);
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet) {
        mongoTemplate.save(legoSet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        mongoTemplate.remove(new Query(Criteria.where("id").is(id)), LegoSet.class);
    }
}
