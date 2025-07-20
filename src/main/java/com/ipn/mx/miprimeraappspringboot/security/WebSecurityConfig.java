package com.ipn.mx.miprimeraappspringboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {// Bean de filtro de spring security. Configuración propia de la autenticacion/autorización de spring security. Sobre escribe la propia de spring security
        return http
                .csrf(e -> e.disable())// Deshabilitar autenticacion por tokens CSRF. Esto se hace para aplicaciones de APIS que no manejen o requieran el estado de una sesion que tenga un usuario desde una aplicacion web.
                .authorizeHttpRequests(req ->
                    req.requestMatchers("/v1/books/**").permitAll()
                            .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults())// Permitir la autenticacion basica, es decir, permitir autenticarse con un usuario y contraseña
                .build();
    }

    @Bean
    public UserDetailsService users() {// En este bean de tipo UserDetailsService, que es una interfaz propia de spring security por la cual hay que darle la información a spring cómo son los usuarios (y sus roles) que se van a poder autenticar segun la configuración de SecurityFilterChain
        UserDetails user = User.builder()
                .username("u001")
                .password("{noop}123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
}
