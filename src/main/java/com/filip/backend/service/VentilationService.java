package com.filip.backend.service;

import com.filip.backend.model.VentilationStatus;
import org.springframework.stereotype.Service;

@Service
public class VentilationService {

    public VentilationStatus getStatus() {
        return new VentilationStatus(
                18.5,
                21.2,
                67,
                "NORMAL"
        );
    }
}