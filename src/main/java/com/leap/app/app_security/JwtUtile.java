package com.leap.app.app_security;

import java.util.Date;


import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class JwtUtile {

    public static String generateToken(User user){
        return Jwts.builder().subject(user.getUsername()).expiration(new Date(System.currentTimeMillis()+604_800_000)).signWith(getSignKey()).compact();
    }

    public static Claims getClaims(String token){
        return Jwts.parser().verifyWith(getSignKey()).build().parseSignedClaims(token).getPayload();
    }

    public static boolean isTokenvalid (String token){
        return !isExpared(token);
    }
    private static boolean isExpared(String token) {
        return getClaims(token).getExpiration().before(new Date());
    }

    private static SecretKey getSignKey() {
        // This is just a test key, SO IT IS NOT WHAT I USED IN THE PRODUCTION
        byte[] key = Decoders.BASE64.decode("thisisJustToTest123ThisIsForPubliCNOTACTUALKEYNOTSECURE123");
        return Keys.hmacShaKeyFor(key);
            
    }
    
}
