package com.digitalfix.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            // Deshabilitar CSRF porque nuestro BFF funcionará como una API REST stateless
            .csrf(csrf -> csrf.disable())
            
            // Exigir que TODAS las peticiones estén autenticadas
            .authorizeHttpRequests(authz -> authz
                .anyRequest().authenticated()
            )
            
            // Habilitar la validación del JWT de Azure (lee el application.properties automáticamente)
            .oauth2ResourceServer(oauth2 -> oauth2
                .jwt(jwt -> {}) 
            );

        return http.build();
    }
}