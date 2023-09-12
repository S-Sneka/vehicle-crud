package com.codingmart.vehiclecrudtask.service;

import com.codingmart.vehiclecrudtask.entity.Vehicle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    Vehicle createVehicle(Vehicle vehicle);

    Vehicle getVehicleById(Long id);

    Vehicle updateVehicle(Vehicle vehicle, Long id);

    String deleteVehicle(Long id);

    Page<Vehicle> getAllVehicles(Pageable pageable);
    Page<Vehicle> getVehiclesByPurchasingYear(int year, Pageable pageable);
    Page<Vehicle> getVehiclesByColor(String color, Pageable pageable);
    Page<Vehicle> getVehiclesByRegisterNo(Long registerNo, Pageable pageable);
}
