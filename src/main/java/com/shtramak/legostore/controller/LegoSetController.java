package com.shtramak.legostore.controller;

import com.shtramak.legostore.model.LegoSet;
import com.shtramak.legostore.service.LegoSetService;
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
    private final LegoSetService service;

    public LegoSetController(LegoSetService service) {
        this.service = service;
    }

    @PostMapping
    public void insert(@RequestBody LegoSet legoSet) {
        service.insert(legoSet);
    }

    @GetMapping
    public List<LegoSet> findAll() {
        return service.findAll();
    }

    @PutMapping
    public void update(@RequestBody LegoSet legoSet) {
        service.update(legoSet);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.delete(id);
    }
}
