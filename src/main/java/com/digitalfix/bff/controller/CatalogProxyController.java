package com.digitalfix.bff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/catalog")
public class CatalogProxyController {

    @Autowired
    private RestTemplate restTemplate;

    // La dirección interna de tu microservicio de Catálogo
    private final String CATALOG_URL = "http://localhost:8081/api/catalog/services";

    // Reenvía la petición GET
    @GetMapping("/services")
    public ResponseEntity<?> getCatalogServices() {
        // El BFF va a buscar los datos al puerto 8081 y los devuelve
        ResponseEntity<Object> response = restTemplate.getForEntity(CATALOG_URL, Object.class);
        return ResponseEntity.ok(response.getBody());
    }

    // Reenvía la petición POST
    @PostMapping("/services")
    public ResponseEntity<?> createCatalogService(@RequestBody Object item) {
        // El BFF recibe el JSON del frontend y se lo lanza al puerto 8081
        ResponseEntity<Object> response = restTemplate.postForEntity(CATALOG_URL, item, Object.class);
        return ResponseEntity.ok(response.getBody());
    }
}