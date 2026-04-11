package com.filip.backend.service;

import com.digitalpetri.modbus.client.ModbusTcpClient;
import com.digitalpetri.modbus.client.ModbusTcpClientConfig;
import com.digitalpetri.modbus.pdu.ReadHoldingRegistersRequest;
import com.digitalpetri.modbus.pdu.ReadHoldingRegistersResponse;
import io.netty.buffer.ByteBuf;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ModbusReaderService {

    private final String host;
    private final int port;
    private final int unitId;

    public ModbusReaderService(
            @Value("${ventilation.modbus.host}") String host,
            @Value("${ventilation.modbus.port}") int port,
            @Value("${ventilation.modbus.unit-id}") int unitId
    ) {
        this.host = host;
        this.port = port;
        this.unitId = unitId;
    }

    public List<Integer> readHoldingRegisters(int startAddress, int count) {
        ModbusTcpClientConfig config = new ModbusTcpClientConfig.Builder(host)
                .setPort(port)
                .setTimeout(Duration.ofSeconds(3))
                .build();

        ModbusTcpClient client = new ModbusTcpClient(config);

        try {
            client.connect().get();

            var request = new ReadHoldingRegistersRequest(startAddress, count);
            var response = (ReadHoldingRegistersResponse) client.sendRequest(request, unitId).get();

            ByteBuf buf = response.registers();
            List<Integer> values = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                values.add(buf.readUnsignedShort());
            }

            return values;
        } catch (Exception e) {
            throw new RuntimeException("Failed to read Modbus registers", e);
        } finally {
            try {
                client.disconnect().get();
            } catch (Exception ignored) {
            }
        }
    }
}