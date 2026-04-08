package com.filip.backend.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/ventilation")
public class VentilationController {

    @GetMapping("/status")
    public Map<String, Object> getStatus() {
        return Map.of(
                "supplyTemp", 21.5,
                "extractTemp", 22.0,
                "fanSpeed", 70,
                "mode", "NORMAL"
        );
    }
}