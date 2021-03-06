package com.example.wallet.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

import static java.util.Collections.emptyList;

public class AuthenticationService {
    static final long EXPIRATION_TIME = 864_000_00;
    static final String SIGNING_KEY = "signingKey";
    static final String BEARER_FIX = "Bearer";

    static public void addJWTToken(HttpServletResponse response, String username){
        String jwtToken = Jwts.builder().setSubject(username)
                                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                                        .signWith(SignatureAlgorithm.HS512, SIGNING_KEY)
                                        .compact();

        response.addHeader("Authorization", BEARER_FIX + " " + jwtToken);
        response.addHeader("Access-Control-Expose-Headers", "Authorization");
    }

    static public Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader("Authorization");

        if(token != null){
            String user = Jwts.parser()
                    .setSigningKey(SIGNING_KEY)
                    .parseClaimsJws(token.replace(BEARER_FIX, ""))
                    .getBody()
                    .getSubject();

            if(user != null){
                return new UsernamePasswordAuthenticationToken(user, null, emptyList());
            } else {
                throw new RuntimeException("Authentication failed");
            }
        }
        return null;
    }
}