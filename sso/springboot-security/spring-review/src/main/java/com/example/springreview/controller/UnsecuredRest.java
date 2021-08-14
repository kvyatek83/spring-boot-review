package com.example.springreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/unsecured")
@RestController
public class UnsecuredRest {

    @RequestMapping("/")
    public String getRoot(){
        return "Unsecured root!";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "Unsecured index!";
    }
}
