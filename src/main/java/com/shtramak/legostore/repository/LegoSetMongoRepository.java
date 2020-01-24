package com.shtramak.legostore.repository;

import com.shtramak.legostore.model.LegoSet;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LegoSetMongoRepository extends MongoRepository<LegoSet, String> {
}
