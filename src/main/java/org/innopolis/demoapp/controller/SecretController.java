package org.innopolis.demoapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secret")
public class SecretController {

    @GetMapping
    public SecretDto getSecret() {
        return new SecretDto("This secret text is visible only to authorized users.");
    }

}
