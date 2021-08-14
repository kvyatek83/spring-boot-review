package com.example.baeldungkeycloak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/s")
public class SecuredController {
    @GetMapping(path = "/")
    public String getRoot(){
        return "consumersRoot";
    }
    @GetMapping(path = "/c")
    public String getConsumers(){
        return "consumers";
    }
}