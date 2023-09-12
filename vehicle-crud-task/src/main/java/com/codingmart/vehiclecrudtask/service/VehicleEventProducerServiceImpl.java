package com.codingmart.vehiclecrudtask.service;

import com.codingmart.vehiclecrudtask.entity.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VehicleEventProducerServiceImpl implements VehicleEventProducerService {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;


    @SneakyThrows
    @Override
    public void produceVehicleCreatedEvent(Vehicle vehicle) {

        String message=objectMapper.writeValueAsString(vehicle);
        kafkaTemplate.send("vehicle-create-events",vehicle.getId().toString(), message);
    }

    @SneakyThrows
    @Override
    public void produceVehicleUpdatedEvent(Vehicle vehicle) {

        String message=objectMapper.writeValueAsString(vehicle);
        kafkaTemplate.send("vehicle-update-events",vehicle.getId().toString(), message);
    }

    @Override
    public void produceVehicleDeletedEvent(Long vehicleId) {
        kafkaTemplate.send("vehicle-delete-events", vehicleId.toString());
    }
}
