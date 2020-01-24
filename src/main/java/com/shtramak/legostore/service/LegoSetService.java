package com.shtramak.legostore.service;

import com.shtramak.legostore.model.LegoSet;

import java.util.List;

public interface LegoSetService {
    void insert(LegoSet legoSet);

    List<LegoSet> findAll();

    void update(LegoSet legoSet);

    void delete(String id);

}
