package com.filip.backend.model;

import java.util.List;

public class VentilationStatus {
    private final int supplyFanPercent;
    private final int extractFanPercent;
    private final int recoveryPercent;
    private final int rawReg0;
    private final int rawReg1;
    private final String mode;
    private final List<Integer> rawRegisters;

    public VentilationStatus(
            int supplyFanPercent,
            int extractFanPercent,
            int recoveryPercent,
            int rawReg0,
            int rawReg1,
            String mode,
            List<Integer> rawRegisters
    ) {
        this.supplyFanPercent = supplyFanPercent;
        this.extractFanPercent = extractFanPercent;
        this.recoveryPercent = recoveryPercent;
        this.rawReg0 = rawReg0;
        this.rawReg1 = rawReg1;
        this.mode = mode;
        this.rawRegisters = rawRegisters;
    }

    public int getSupplyFanPercent() { return supplyFanPercent; }
    public int getExtractFanPercent() { return extractFanPercent; }
    public int getRecoveryPercent() { return recoveryPercent; }
    public int getRawReg0() { return rawReg0; }
    public int getRawReg1() { return rawReg1; }
    public String getMode() { return mode; }
    public List<Integer> getRawRegisters() { return rawRegisters; }
}