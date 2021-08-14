package com.example.springreview.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/secured")
@RestController
public class SecuredRest {

    @RequestMapping("/")
    public String getRoot(){
        return "Secured root!";
    }

    @RequestMapping("/index")
    public String getIndex(){
        return "Secured index!";
    }
}
