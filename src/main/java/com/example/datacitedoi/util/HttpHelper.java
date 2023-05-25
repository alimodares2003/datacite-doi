package com.example.datacitedoi.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class HttpHelper {
    public static String getCall(String url) {
        RestTemplate restTemplate = new RestTemplate();
        System.setProperty("https.protocols", "TLSv1,TLSv1.1,TLSv1.2");
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
}
