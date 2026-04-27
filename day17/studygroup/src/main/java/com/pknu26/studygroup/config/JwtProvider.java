package com.pknu26.studygroup.config;

import java.nio.charset.StandardCharsets;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.security.keys;

@Component
public class JwtProvider {

    private final SecretKey secretKey;
    private final long accessTokenExiration;

    public JwtProvider(@Value("${jwt.secret}") String secret,
                       @Value("${jwt.expiration}") long accessTokenExiration) {
        // jwt.secret에 설정된 평문암호 설정값을 암호화해서
        // H
        this.secretKey = Keys.hmacShakeyFor(secret.getBytes(StandardCharsets.UTF_8));
        this.accessTokenExiration = accessTokenExiration;
    }

    public Claims getClaims(String token) {

    }

    public boolean validation(String token) {

    }

    public String getLoginId(String token){

    }
}
