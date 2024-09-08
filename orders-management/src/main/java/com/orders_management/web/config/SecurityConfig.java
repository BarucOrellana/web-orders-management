package com.orders_management.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    private final JwtFilter jwtFilter;

    @Autowired
    public SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(customizeRequests ->{
            customizeRequests
                    .requestMatchers("/auth/**").permitAll()
                    .requestMatchers("/customer/**").hasRole("SALES")
                    .requestMatchers("/destination/**").hasRole("SALES")
                    .requestMatchers("/operator/**").hasRole("OPERATION")
                    .requestMatchers("/truck/**").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.GET, "/orders/*").hasRole("FINANCE")
                    .requestMatchers(HttpMethod.GET, "/orders/summary/operation").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.GET, "/orders/summary/sales").hasRole("SALES")
                    .requestMatchers(HttpMethod.POST, "/orders/*").hasRole("SALES")
                    .requestMatchers(HttpMethod.PUT, "/orders/*").hasRole("FINANCE")
                    .requestMatchers(HttpMethod.PUT, "/orders/operation/*").hasRole("OPERATION")
                    .requestMatchers(HttpMethod.PUT, "/orders/sales/*").hasRole("SALES")
                    .requestMatchers(HttpMethod.DELETE, "/orders/*").hasRole("SALES")
                    .anyRequest().authenticated();
        })                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .csrf(AbstractHttpConfigurer::disable).cors(Customizer.withDefaults())
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);;
        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
        return http.getSharedObject(AuthenticationManagerBuilder.class)
                .build();
    }
}
