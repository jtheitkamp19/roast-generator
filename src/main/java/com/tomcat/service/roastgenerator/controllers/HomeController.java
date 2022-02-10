package com.tomcat.service.roastgenerator.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

public class HomeController {
    @GetMapping
    @RequestMapping("/")
    public Map getStatus() {
        Map map = new HashMap<String, String>();
        map.put("app-version", "1.0.0");
        return map;
    }
}
