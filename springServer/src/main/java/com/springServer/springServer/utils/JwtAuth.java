package com.springServer.springServer.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtAuth {

    private String Secret_Key = "TaK+HaV^uvCHEFsEVfypW#7g9^k*Z8$V";

    private SecretKey signKey() {
        return Keys.hmacShaKeyFor(Secret_Key.getBytes());
    }

    public String getUserName(String token) {
        // Claims is basically a object that returns all token claims
        Claims claims = extrClaims(token);
        // getSubject it returns the name that are used in the claims that things return
        return claims.getSubject();
    }
    private Claims extrClaims(String token) {
        return Jwts.parser()
                .verifyWith(signKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
    
    public String generatetoken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }
    public Date extractExpiration(String token) {
        return extrClaims(token).getExpiration();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .claims(claims)
                .subject(subject)
                .header().empty().add("typ", "JWT")
                .and()
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(signKey())
                .compact();
    }
    public Boolean validateToken(String token) {
        return !isTokenExpired(token);
    }
}
