package com.masterlab.deepseek_springboot_ai.service;

import com.masterlab.deepseek_springboot_ai.dtos.ChatRequest;
import com.masterlab.deepseek_springboot_ai.dtos.ChatResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DeepSeekService {

    @Value("${deepseek.api-key}")
    private String apiKey;

    @Value("${deepseek.api-url}")
    private String apiUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public ChatResponse sendPrompt(ChatRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(apiKey);
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> payload = Map.of(
                "model", "deepseek-chat",
                "messages", List.of(Map.of("role", "user", "content", request.getPrompt()))
        );

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(payload, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(apiUrl, entity, Map.class);
        List choices = (List) response.getBody().get("choices");
        Map<String, Object> firstChoice = (Map<String, Object>) choices.get(0);
        Map<String, String> message = (Map<String, String>) firstChoice.get("message");

        ChatResponse chatResponse = new ChatResponse();
        chatResponse.setResponse(message.get("content"));
        return chatResponse;
    }
}

