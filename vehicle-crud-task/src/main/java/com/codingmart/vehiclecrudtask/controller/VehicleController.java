package com.codingmart.vehiclecrudtask.controller;

import com.codingmart.vehiclecrudtask.entity.Vehicle;
import com.codingmart.vehiclecrudtask.response.GenericResponse;
import com.codingmart.vehiclecrudtask.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vehicles")
public class VehicleController {
      private final VehicleService vehicleService;

    @PostMapping(value = "",consumes = "application/json")
    public GenericResponse<Vehicle> createVehicle(@RequestBody Vehicle vehicle){
        return GenericResponse.<Vehicle>builder()
                .code(201)
                .status(HttpStatus.CREATED)
                .data(vehicleService.createVehicle(vehicle))
                .build();
    }

    @GetMapping("/{id}")
    public GenericResponse<Vehicle> getVehicleById(@PathVariable("id") Long id){
        return GenericResponse.<Vehicle>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.getVehicleById(id))
                .build();
    }

    @GetMapping("/year")
    public GenericResponse<List<Vehicle>> getVehiclesByPurchasingYearWithPagination(
            @RequestParam int year,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return GenericResponse.<List<Vehicle>>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.getVehiclesByPurchasingYear(year, pageable).getContent())
                .build();
    }

    @GetMapping("/color")
    public GenericResponse<List<Vehicle>> getVehiclesByColorWithPagination(
            @RequestParam String color,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return GenericResponse.<List<Vehicle>>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.getVehiclesByColor(color, pageable).getContent())
                .build();
    }


    @GetMapping("/registerNo")
    public GenericResponse<List<Vehicle>> getVehiclesByRegisterNoWithPagination(
            @RequestParam Long registerNo,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return GenericResponse.<List<Vehicle>>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.getVehiclesByRegisterNo(registerNo, pageable).getContent())
                .build();
    }


    // Read all vehicles
    @GetMapping("/all")
    public GenericResponse<List<Vehicle>> getAllVehiclesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);

        return GenericResponse.<List<Vehicle>>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.getAllVehicles(pageable).getContent())
                .build();
    }


    @PutMapping(value = "/{id}",consumes = "application/json")
    public GenericResponse<Vehicle> updateVehicle(@RequestBody Vehicle vehicle,@PathVariable("id") Long id){
        return GenericResponse.<Vehicle>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(vehicleService.updateVehicle(vehicle,id))
                .build();
    }


    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteVehicle(@PathVariable("id") Long id){
        return GenericResponse.<String>builder()
                .code(204)
                .status(HttpStatus.NO_CONTENT)
                .data(vehicleService.deleteVehicle(id))
                .build();
    }


}
