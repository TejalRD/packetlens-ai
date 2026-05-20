package com.tejal.packetlens_ai.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class OllamaService {

    private final RestClient restClient;

    public OllamaService() {
        this.restClient = RestClient.builder()
                .baseUrl("http://localhost:11434")
                .build();
    }

    public String analyzePacketData(String packetData) {

        String prompt = """
                You are a network troubleshooting assistant.

                Analyze the following packet capture / Wireshark summary.

                Return the answer in this format:
                1. Traffic Summary
                2. Detected Issue
                3. Evidence
                4. Likely Root Cause
                5. Recommended Debugging Steps

                Packet Data:
                """ + packetData;

        Map<String, Object> requestBody = Map.of(
                "model", "mistral",
                "prompt", prompt,
                "stream", false
        );

        Map response = restClient.post()
                .uri("/api/generate")
                .body(requestBody)
                .retrieve()
                .body(Map.class);

        return response.get("response").toString();
    }
}