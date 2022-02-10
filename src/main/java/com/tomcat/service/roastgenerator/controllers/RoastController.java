package com.tomcat.service.roastgenerator.controllers;

import com.tomcat.service.roastgenerator.models.Roast;
import com.tomcat.service.roastgenerator.repositories.RoastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/roast")
public class RoastController {
    @Autowired
    private RoastRepository roastRepository;

    @GetMapping("{id}")
    public Roast getById(@PathVariable Long id) {
        return roastRepository.getById(id);
    }

    @GetMapping
    public Roast getRandomRoast() {
        int roastCount = roastRepository.getRoastCount();
        Random rand = new Random();

        return roastRepository.getById((long)rand.nextInt(roastCount) + 1);
    }

    @PostMapping
    public Roast create(@RequestBody Roast roast) {
        roastRepository.saveAndFlush(roast);
        return roast;
    }
}
