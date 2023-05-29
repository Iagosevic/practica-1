package com.qindel.practicas.practica1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class CustomWebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .passwordEncoder(passwordEncoder)
                .withUser("user").password("$2a$10$9Xn39aPf4LhDpRGNWvDFqu.T5ZPHbyh8iNQDSb4aNSnLqE2u2efIu")
                .roles("USER").and().passwordEncoder(passwordEncoder).withUser("admin")
                .password("$2a$10$dl8TemMlPH7Z/mpBurCX8O4lu0FoWbXnhsHTYXVsmgXyzagn..8rK").roles("USER","ADMIN");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Secured("ROLE_VIEWER")
    public String getUsername() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return securityContext.getAuthentication().getName();
    }

    @PreAuthorize("hasRole('ROLE_VIEWER')")
    public String getUsernameInUpperCase() {
        return getUsername().toUpperCase();
    }
}