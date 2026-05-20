package com.tejal.packetlens_ai.controller;

import com.tejal.packetlens_ai.Model.PacketRequest;
import com.tejal.packetlens_ai.service.OllamaService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    private final OllamaService ollamaService;

    public TestController(OllamaService ollamaService) {
        this.ollamaService = ollamaService;
    }

    @GetMapping("/health")
    public String health() {
        return "PacketLens AI is running";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestBody PacketRequest request) {
        return ollamaService.analyzePacketData(request.getPacketData());
    }
}