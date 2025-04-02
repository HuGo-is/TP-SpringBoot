package com.example.demo.services;

import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class ArenaRegistrationService {

    private final RestTemplate restTemplate;

    public ArenaRegistrationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void registerToArena(String serverUrl, String studentName, String baseUrl) {
        String registrationUrl = serverUrl + "/arena/register";

        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("studentName", studentName);
        requestBody.put("baseUrl", baseUrl);

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setStudentName(studentName);
        registerRequest.setBaseUrl(baseUrl);



        String response = restTemplate.postForObject(registrationUrl, registerRequest, String.class);
        System.out.println(response);
    }

    @Data
    class RegisterRequest {
        String studentName;
        String baseUrl;
    }
}
