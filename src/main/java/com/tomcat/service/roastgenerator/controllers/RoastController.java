package com.tomcat.service.roastgenerator.controllers;

import com.tomcat.service.roastgenerator.models.Infographics;
import com.tomcat.service.roastgenerator.models.Roast;
import com.tomcat.service.roastgenerator.repositories.RoastRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@RequestMapping("/api/v1/roast")
public class RoastController {
    @Autowired
    private RoastRepository roastRepository;

    @GetMapping("/info")
    public Infographics getInfo() {
        Infographics info = new Infographics();
        info.setCount(roastRepository.getRoastCount());
        info.setData(Arrays.asList(roastRepository.findAll().toArray()));
        return info;
    }

    @GetMapping("{id}")
    public Roast getById(@PathVariable Long id) {
        return roastRepository.getById(id);
    }

    @PostMapping
    public Roast create(@RequestBody Roast roast) {
        roast.setId((long)roastRepository.getCurrentId() + 1);
        roastRepository.saveAndFlush(roast);
        return roast;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public Roast update(@PathVariable Long id, @RequestBody Roast roast) {
        Roast existingRoast = roastRepository.getById(id);
        BeanUtils.copyProperties(roast, existingRoast);
        roastRepository.saveAndFlush(existingRoast);
        return existingRoast;
    }

    @GetMapping("/localize")
    public List<Roast> fetchAndRemove() {
        List<Roast> roasts = roastRepository.findAll();
        roastRepository.deleteAll();
        return roasts;
    }
}
