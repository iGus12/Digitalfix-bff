package com.digitalfix.bff.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bff")
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        return "¡Hola! El BFF está funcionando. Si ves este mensaje, es porque tu token JWT es válido y pasaste la seguridad.";
    }
}