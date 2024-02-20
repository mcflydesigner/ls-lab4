package org.innopolis.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping
    public HelloDto getHello() {
        return new HelloDto( "Hello world!");
    }
}
