package com.filip.backend.controller;

import com.filip.backend.model.VentilationStatus;
import com.filip.backend.service.VentilationService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api/ventilation")
public class VentilationController {

    private final VentilationService ventilationService;

    public VentilationController(VentilationService ventilationService) {
        this.ventilationService = ventilationService;
    }

    @GetMapping("/status")
    public VentilationStatus getStatus() {
        return ventilationService.getStatus();
    }
}