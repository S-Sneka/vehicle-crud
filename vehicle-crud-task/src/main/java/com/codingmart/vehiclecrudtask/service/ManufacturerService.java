package com.codingmart.vehiclecrudtask.service;

import com.codingmart.vehiclecrudtask.entity.Manufacturer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ManufacturerService {
    Manufacturer createManufacturer(Manufacturer manufacturer);

    Manufacturer getManufacturerById(Long id);

    List<Manufacturer> getAllManufacturers();

    Manufacturer updateManufacturer(Manufacturer manufacturer, Long id);

    String deleteManufacturer(Long id);
}