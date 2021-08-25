package com.example.bkg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/u")
public class UnsecuredControlled {
    @Value("${keycloak.auth-server-url}")
    private String url;

    @GetMapping(path = "/c")
    public String getConsumers(){
        return url;
    }
}
