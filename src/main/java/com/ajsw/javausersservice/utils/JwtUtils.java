package com.ajsw.javausersservice.utils;

import com.ajsw.javausersservice.models.dto.JwtUserDetails;
import com.ajsw.javausersservice.models.entities.Account;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    @Value("${jwt.private-key}")
    private String signedKey;

    public String generateToken(Account account) {
        Claims claims = Jwts.claims().setSubject(Integer.toString(account.getIdAccount()));
        claims.setIssuedAt(new Date(System.currentTimeMillis()));
        claims.setExpiration(new Date(System.currentTimeMillis() + (300 * 2000)));
        claims.put("accountEmail", account.getEmail());
        claims.put("role", account.getRole().getDescription());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, signedKey)
                .compact();
    }

    public JwtUserDetails validateToken(String authToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(signedKey).parseClaimsJws(authToken).getBody();
            Date expireTime = claims.getExpiration();

            if (expireTime.before(new Date(System.currentTimeMillis()))) {
                throw new RuntimeException("token is expired");
            }

            return JwtUserDetails
                    .builder()
                    .accountEmail((String) claims.get("accountEmail"))
                    .role((String) claims.get("role"))
                    .accountId(claims.getSubject())
                    .build();

        } catch (Exception ex) {
            throw new RuntimeException("token is not valid");
        }
    }
}
