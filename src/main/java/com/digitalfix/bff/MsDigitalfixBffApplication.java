package com.digitalfix.bff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MsDigitalfixBffApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsDigitalfixBffApplication.class, args);
	}

	// Agregamos esto para que el BFF pueda hacer llamadas a otros microservicios
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}