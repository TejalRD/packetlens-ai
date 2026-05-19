package com.tejal.packetlens_ai.controller;

import com.tejal.packetlens_ai.Model.PacketRequest;
import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("/health")
    public String health() {
        return "PacketLens AI is running";
    }

    @PostMapping("/analyze")
    public String analyze(@RequestBody PacketRequest request) {

        String packetData = request.getPacketData();

        return """
                Packet Analysis Result

                Received Packet Data:
                """ + packetData;
    }
}