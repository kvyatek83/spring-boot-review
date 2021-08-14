package com.example.baeldungkeycloak.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/u")
public class UnsecuredController {
    @GetMapping(path = "/c")
    public String getConsumers(){
        return "consumers";
    }
}
