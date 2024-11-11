package com.example.sell_airline_ticket.service.authentication;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import javax.crypto.SecretKey;
import java.util.Collections;
import java.util.Date;

@Service
public class JwtService {
    private static final SecretKey secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    //generate token with username
    public String generateToken(Authentication authentication) {
        return Jwts.builder()
                .setSubject(authentication.getName())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 12)) // 12 giờ
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getExpiration();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !isTokenExpired(token);
        } catch (SignatureException e) {
            System.out.println("Invalid JWT signature: " + e.getMessage());
        } catch (MalformedJwtException e) {
            System.out.println("Invalid JWT token: " + e.getMessage());
        } catch (ExpiredJwtException e) {
            System.out.println("JWT token is expired: " + e.getMessage());
        } catch (UnsupportedJwtException e) {
            System.out.println("JWT token is unsupported: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("JWT claims string is empty: " + e.getMessage());
        }
        return false;
    }

    // Tạo Authentication object từ token
    public Authentication getAuthentication(String token) {
        String username = extractUsername(token);

        return new UsernamePasswordAuthenticationToken(
                username,  // principal
                null,     // credentials
                Collections.emptyList()  // authorities rỗng
        );
    }

    public boolean isTokenValid(String token) {
        try {
            return validateToken(token);
        } catch (Exception e) {
            System.out.println("Error validating token: {}" + e.getMessage());
            return false;
        }
    }
}
