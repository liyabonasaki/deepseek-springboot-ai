package com.masterlab.deepseek_springboot_ai.controller;

import com.masterlab.deepseek_springboot_ai.dtos.ChatRequest;
import com.masterlab.deepseek_springboot_ai.dtos.ChatResponse;
import com.masterlab.deepseek_springboot_ai.service.DeepSeekService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ask")
@RequiredArgsConstructor
public class ChatController {


    private final DeepSeekService deepSeekService;

    @PostMapping
    public ResponseEntity<ChatResponse> ask(@RequestBody ChatRequest request) {
        return ResponseEntity.ok(deepSeekService.sendPrompt(request));
    }
}
