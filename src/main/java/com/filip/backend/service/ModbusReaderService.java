package com.filip.backend.service;


import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Service;


import java.io.BufferedReader;

import java.io.InputStreamReader;

import java.util.ArrayList;

import java.util.List;


@Service

public class ModbusReaderService {


    private final String host;

    private final int port;


    public ModbusReaderService(

            @Value("${ventilation.modbus.host}") String host,

            @Value("${ventilation.modbus.port}") int port

    ) {

        this.host = host;

        this.port = port;

    }


    public List<Integer> readHoldingRegisters() {

        try {

            Process process = new ProcessBuilder(

                    "/home/filip/modbus-env/bin/python",

                    "/home/filip/test_modbus_json.py",

                    host,

                    String.valueOf(port)

            ).start();


            BufferedReader reader = new BufferedReader(

                    new InputStreamReader(process.getInputStream())

            );


            String line = reader.readLine();

            process.waitFor();


            if (line == null || line.isBlank()) {

                throw new RuntimeException("No data returned from Python script");

            }


            String cleaned = line.replace("[", "").replace("]", "").trim();

            if (cleaned.isEmpty()) {

                return List.of();

            }


            String[] parts = cleaned.split(",");

            List<Integer> values = new ArrayList<>();


            for (String part : parts) {

                values.add(Integer.parseInt(part.trim()));

            }


            return values;

        } catch (Exception e) {

            throw new RuntimeException("Failed to read Modbus data", e);

        }

    }

}