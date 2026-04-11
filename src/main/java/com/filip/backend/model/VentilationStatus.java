package com.filip.backend.model;

public class VentilationStatus {

    private double supplyTemperature;
    private double extractTemperature;
    private int fanSpeed;
    private String mode;

    public VentilationStatus() {
    }

    public VentilationStatus(double supplyTemperature, double extractTemperature, int fanSpeed, String mode) {
        this.supplyTemperature = supplyTemperature;
        this.extractTemperature = extractTemperature;
        this.fanSpeed = fanSpeed;
        this.mode = mode;
    }

    public double getSupplyTemperature() {
        return supplyTemperature;
    }

    public void setSupplyTemperature(double supplyTemperature) {
        this.supplyTemperature = supplyTemperature;
    }

    public double getExtractTemperature() {
        return extractTemperature;
    }

    public void setExtractTemperature(double extractTemperature) {
        this.extractTemperature = extractTemperature;
    }

    public int getFanSpeed() {
        return fanSpeed;
    }

    public void setFanSpeed(int fanSpeed) {
        this.fanSpeed = fanSpeed;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }
}