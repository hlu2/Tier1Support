package com.intuit.tier1.controller;

import com.intuit.tier1.service.MonkeyLearnService;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class DefaultController {
    @Autowired
    private MonkeyLearnService service;

    @RequestMapping("/")
    public String index(){
         return "Hello World";
    }

    @RequestMapping(value="/monkeylearn", method=RequestMethod.GET)
    public String sample(@RequestParam String body) {
        return service.sampleRun(body);
    }

    @RequestMapping(value="/monkeylearn", method=RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public String postSample(HttpEntity<String> httpEntity) {
        String json = httpEntity.getBody();
        return service.sampleRun(json);
    }
}
