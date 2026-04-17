package com.filip.backend.service;


import com.filip.backend.model.VentilationStatus;

import org.springframework.stereotype.Service;


import java.util.List;


@Service

public class VentilationService {


    private final ModbusReaderService modbusReaderService;


    public VentilationService(ModbusReaderService modbusReaderService) {

        this.modbusReaderService = modbusReaderService;

    }


    public VentilationStatus getStatus() {

        List<Integer> regs = modbusReaderService.readHoldingRegisters();


        if (regs.size() < 6) {

            throw new RuntimeException("Not enough Modbus data returned");

        }


        return new VentilationStatus(

                regs.get(RegisterMap.SUPPLY_FAN_PERCENT),

                regs.get(RegisterMap.EXTRACT_FAN_PERCENT),

                regs.get(RegisterMap.RECOVERY_PERCENT),

                regs.get(RegisterMap.RAW_REG_0),

                regs.get(RegisterMap.RAW_REG_1),

                "UNKNOWN",

                regs

        );

    }

}