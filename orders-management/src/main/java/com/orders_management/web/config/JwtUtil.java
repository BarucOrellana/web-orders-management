package com.orders_management.web.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class JwtUtil {
    private static String SECRET_KEY = "Administracion-Chacon";
    private static Algorithm ALGORITHM = Algorithm.HMAC256(SECRET_KEY);

    public String create(String username){
        return JWT.create().withSubject(username).withIssuer("Chacon").withIssuedAt(new Date()).withExpiresAt(new Date(System.currentTimeMillis()+TimeUnit.DAYS.toMillis(15))).sign(ALGORITHM);
    }

    public boolean isValid(String jwt){
        try{
            JWT.require(ALGORITHM).build().verify(jwt);
            return true;
        } catch (JWTVerificationException exception){
            return false;
        }
    }

    public String getUserName(String jwt){
        return JWT.require(ALGORITHM).build().verify(jwt).getSubject();
    }

}
