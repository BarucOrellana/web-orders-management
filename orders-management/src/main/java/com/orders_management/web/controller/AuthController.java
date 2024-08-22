package com.orders_management.web.controller;

import com.orders_management.domain.dto.UserDto;
import com.orders_management.domain.service.EmailService;
import com.orders_management.domain.service.UserService;
import com.orders_management.domain.util.AuthenticationCodeUtil;
import com.orders_management.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserService userService;
    private final EmailService emailService;
    private final RedisTemplate<String, String> redisTemplate;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserService userService, EmailService emailService, RedisTemplate<String, String> redisTemplate) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userService = userService;
        this.emailService = emailService;
        this.redisTemplate = redisTemplate;
    }

    @PostMapping("/auth")
    public ResponseEntity<Void> auth(@RequestBody UserDto dto){
        if(this.userService.exist(dto.getUsername())){
            String token = AuthenticationCodeUtil.getToken(6);
            this.emailService.getAuthenticationToken(this.userService.getEmail(dto), token);
            redisTemplate.opsForValue().set(dto.getUsername(), token, 5, TimeUnit.MINUTES);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    
    @PostMapping("/auth/token")
    public ResponseEntity<Void> authToken(@RequestBody UserDto dto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);
        String cachedAuthCode = redisTemplate.opsForValue().get(dto.getUsername());
        String jwt = jwtUtil.create(dto.getUsername());
        if (cachedAuthCode != null && cachedAuthCode.equals(dto.getToken())) {
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.AUTHORIZATION, jwt);
            return ResponseEntity.ok().headers(headers).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}

