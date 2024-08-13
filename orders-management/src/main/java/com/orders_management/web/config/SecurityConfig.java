package com.orders_management.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizeRequests ->{
            customizeRequests
                    .requestMatchers("/customer/**").hasRole("SALES")
                    .requestMatchers("/destination/**").hasRole("SALES")
                    .requestMatchers("/operator/**").hasRole("OPERATION")
                    .requestMatchers("/truck/**").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.GET, "/orders/*").hasRole("FINANCE")
                    .requestMatchers(HttpMethod.GET, "/orders/summary/operation").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.GET, "/orders/summary/sales").hasRole("SALES")
                    .requestMatchers(HttpMethod.POST, "/orders/*").hasRole("FINANCE")
                    .requestMatchers(HttpMethod.PUT, "/orders/*").hasRole("FINANCE")
                    .requestMatchers(HttpMethod.PUT, "/orders/operation/*").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.PUT, "/orders/sales/*").hasRole("SALES")
                    .requestMatchers(HttpMethod.DELETE, "/orders/*").hasRole("SALES")
                    .anyRequest().authenticated();
        }).csrf(AbstractHttpConfigurer::disable).httpBasic(Customizer.withDefaults());
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
