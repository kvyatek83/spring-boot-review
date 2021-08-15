package com.example.springcloudclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ClientController {

    @Value("${user.role}")
    private String role;

    @Value("${user.lala}")
    private String lala;

    @GetMapping(
            value = "/whoami/{username}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String whoami(@PathVariable("username") String username) {
        return String.format("Hello!You're %s and you'll become a(n) %s...\n", username, role);
    }

    @GetMapping(
            value = "/lala/{username}",
            produces = MediaType.TEXT_PLAIN_VALUE)
    public String lala(@PathVariable("username") String username) {
        return String.format("Hello!You're %s and you'll become a(n) %s...\n", username, lala);
    }
}
