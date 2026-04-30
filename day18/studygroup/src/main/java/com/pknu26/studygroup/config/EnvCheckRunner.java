package com.pknu26.studygroup.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EnvCheckRunner implements CommandLineRunner {

    @Value("${spring.security.oauth2.client.registration.google.client-id:NOT_FOUND}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret:NOT_FOUND}")
    private String clientSecret;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("========= GOOGLE OAUTH2 CHECK =========");

        System.out.println("Client ID : " + AdminHelper.mask(clientId));
        System.out.println("Client Secret : " + AdminHelper.mask(clientSecret));
    }

    // Mask 함수 - 일부 문자열을 ****로 치환
    public static String mask(String value) {
        if (value == null || value.length() < 8) return value;
        return value.substring(0, 5) + "****" + value.substring(value.length() - 5);
    }
}
