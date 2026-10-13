package com.shinsw.working_record_backend.auth.jwt;

import com.shinsw.working_record_backend.user.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class JwtService {

    private final SecretKey secretKey;

    public JwtService(@Value("${jwt.secret}") String key) {
        byte[] keyBytes = Decoders.BASE64.decode(key);
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }


    public String provideJwt(User user){
        Instant now = Instant.now();
        Instant expiration = now.plus(30, ChronoUnit.MINUTES);

        String token= Jwts.builder().
                subject(user.getId()).
                claim("role", user.getRole().name()).
                issuedAt(Date.from(now)).
                expiration(Date.from(expiration)).
                signWith(secretKey, Jwts.SIG.HS256).
                compact();
        return token;
    }

    public Claims verifyJwt(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
