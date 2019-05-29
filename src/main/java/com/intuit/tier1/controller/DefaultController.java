package com.intuit.tier1.controller;

import com.intuit.tier1.service.MonkeyLearnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {
    @Autowired
    private MonkeyLearnService service;

    @RequestMapping("/")
    public String index(){
         return "Hello World";
    }

    @RequestMapping("/monkeylearn")
    public String sample() {
        return service.sampleRun();
    }
}
