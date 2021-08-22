package com.example.baeldungkeycloak.endpoints;

import org.springframework.boot.actuate.endpoint.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Endpoint(id = "nutty")
public class NuttyEndpoint {
    @ReadOperation
    public String custom() {
        return "nutty";
    }

    @ReadOperation
    public String customEndPointByName(@Selector String name) {
        return "nutty";
    }

    @WriteOperation
    public void writeOperation(@Selector String name) {
        //perform write operation
    }
    @DeleteOperation
    public void deleteOperation(@Selector String name){
        //delete operation
    }
}
