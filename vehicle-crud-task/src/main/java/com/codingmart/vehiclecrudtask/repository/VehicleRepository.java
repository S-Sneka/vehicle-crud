package com.codingmart.vehiclecrudtask.repository;

import com.codingmart.vehiclecrudtask.entity.User;
import com.codingmart.vehiclecrudtask.entity.Vehicle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle,Long> {

    // Add pagination support for getting vehicles by purchasing year
    Page<Vehicle> findByPurchasingYear(int purchasingYear, Pageable pageable);

    // Add pagination support for getting vehicles by color
    Page<Vehicle> findByVehicleFeature_color(String color, Pageable pageable);

    // Add pagination support for getting vehicles by register number
    Page<Vehicle> findByRegisterNo(Long registerNo, Pageable pageable);
}
