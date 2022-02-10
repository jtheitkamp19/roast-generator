package com.tomcat.service.roastgenerator.controllers;

import com.tomcat.service.roastgenerator.models.Roast;
import com.tomcat.service.roastgenerator.repositories.RoastRepository;
import org.springframework.beans.BeanUtils;
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
        if ( roastRepository.getRoastCount() <= 9900 ) {
            roastRepository.saveAndFlush(roast);
        } else {
            roast.setRoast("Maximum Roast count exceeded, so this roast could not be saved.");
        }
        return roast;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public Roast update(@PathVariable Long id, @RequestBody Roast roast) {
        Roast existingRoast = roastRepository.getById(id);
        BeanUtils.copyProperties(roast, existingRoast);
        roastRepository.saveAndFlush(existingRoast);
        return existingRoast;
    }
}
