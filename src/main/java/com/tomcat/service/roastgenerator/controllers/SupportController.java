package com.tomcat.service.roastgenerator.controllers;

import com.tomcat.service.roastgenerator.models.Infographics;
import com.tomcat.service.roastgenerator.models.Support;
import com.tomcat.service.roastgenerator.repositories.SupportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/v1/support")
public class SupportController {
    @Autowired
    private SupportRepository supportRepository;

    @GetMapping("/info")
    public Infographics getInfo() {
        Infographics info = new Infographics();
        info.setCount(supportRepository.getRoastCount());
        info.setData(Arrays.asList(supportRepository.findAll().toArray()));
        return info;
    }

    @GetMapping("{id}")
    public Support getById(@PathVariable Long id) {
        return supportRepository.getById(id);
    }

    @PostMapping
    public Support create(@RequestBody Support support) {
        supportRepository.saveAndFlush(support);
        return support;
    }

    @RequestMapping(path = "/update/{id}", method = RequestMethod.PUT)
    public Support update(@PathVariable Long id, @RequestBody Support support) {
        Support existingSupport = supportRepository.getById(id);
        BeanUtils.copyProperties(support, existingSupport);
        supportRepository.saveAndFlush(existingSupport);
        return existingSupport;
    }

    @GetMapping("/localize")
    public List<Support> fetchAndRemove() {
        List<Support> supports = supportRepository.findAll();
        supportRepository.deleteAll();
        return supports;
    }
}
