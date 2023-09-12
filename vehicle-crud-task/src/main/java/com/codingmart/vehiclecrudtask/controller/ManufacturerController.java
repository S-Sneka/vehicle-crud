package com.codingmart.vehiclecrudtask.controller;

import com.codingmart.vehiclecrudtask.entity.Manufacturer;
import com.codingmart.vehiclecrudtask.response.GenericResponse;
import com.codingmart.vehiclecrudtask.service.ManufacturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/manufacturer")
public class ManufacturerController {
    private final ManufacturerService manufacturerService;

    @PostMapping(value = "",consumes = "application/json")
    public GenericResponse<Manufacturer> createManufacturer(@RequestBody Manufacturer manufacturer){
        return GenericResponse.<Manufacturer>builder()
                .code(201)
                .status(HttpStatus.CREATED)
                .data(manufacturerService.createManufacturer(manufacturer))
                .build();
    }

    @GetMapping("/{id}")
    public GenericResponse<Manufacturer> getManufacturerById(@PathVariable("id") Long id){
        return GenericResponse.<Manufacturer>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(manufacturerService.getManufacturerById(id))
                .build();
    }

    // Read all manufacturers
    @GetMapping("")
    public GenericResponse<List<Manufacturer>> getAllManufacturers(){
        return GenericResponse.<List<Manufacturer>>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(manufacturerService.getAllManufacturers())
                .build();
    }


    @PutMapping(value = "/{id}",consumes = "application/json")
    public GenericResponse<Manufacturer> updateManufacturer(@RequestBody Manufacturer manufacturer,@PathVariable("id") Long id){
        return GenericResponse.<Manufacturer>builder()
                .code(200)
                .status(HttpStatus.OK)
                .data(manufacturerService.updateManufacturer(manufacturer,id))
                .build();
    }


    @DeleteMapping("/{id}")
    public GenericResponse<String> deleteManufacturer(@PathVariable("id") Long id){
        return GenericResponse.<String>builder()
                .code(204)
                .status(HttpStatus.NO_CONTENT)
                .data(manufacturerService.deleteManufacturer(id))
                .build();
    }


}