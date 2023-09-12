package com.codingmart.vehiclecrudtask.service;

import com.codingmart.vehiclecrudtask.entity.Manufacturer;
import com.codingmart.vehiclecrudtask.exception.NotFoundException;

import com.codingmart.vehiclecrudtask.repository.ManufacturerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class ManufacturerServiceImpl implements ManufacturerService {

    private final ManufacturerRepository manufacturerRepository;


    @Override
    public Manufacturer createManufacturer(Manufacturer manufacturer) {

        log.info("Creating a new manufacturer: {}", manufacturer);

        Manufacturer createdManufacturer = manufacturerRepository.save(manufacturer);

        log.info("Manufacturer created successfully: {}", createdManufacturer);

        return createdManufacturer;
    }


    @Override
    public Manufacturer getManufacturerById(Long id) {

        log.info("Fetching manufacturer by ID: {}", id);

        if (manufacturerRepository.findById(id).isEmpty()) {

            log.warn("Manufacturer with ID {} not found", id);
            throw new NotFoundException("Manufacturer Id not Found");
        }

        Manufacturer manufacturer = manufacturerRepository.findById(id).get();


        log.info("Found manufacturer: {}", manufacturer);

        return manufacturer;
    }

    @Override
    public List<Manufacturer> getAllManufacturers() {

        log.info("Fetching all manufacturers");
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        log.info("Found {} manufacturers", manufacturers.size());

        return manufacturers;
    }

    @Override
    public Manufacturer updateManufacturer(Manufacturer manufacturer, Long id) {

        log.info("Updating manufacturer with ID {}: {}", id, manufacturer);
        if (manufacturerRepository.findById(id).isEmpty()) {
            log.warn("Manufacturer with ID {} not found", id);
            throw new NotFoundException("Manufacturer Id not Found");
        }

        manufacturer.setId(id);
        Manufacturer updatedManufacturer = manufacturerRepository.save(manufacturer);
        log.info("Manufacturer updated successfully: {}", updatedManufacturer);

        return updatedManufacturer;
    }

    @Override
    public String deleteManufacturer(Long id) {
        log.info("Deleting manufacturer with ID: {}", id);

        if (manufacturerRepository.findById(id).isEmpty()) {
            log.warn("Manufacturer with ID {} not found", id);
            throw new NotFoundException("Manufacturer Id not Found");
        }

        manufacturerRepository.deleteById(id);
        log.info("Manufacturer with ID {} deleted successfully", id);

        return "Manufacturer deleted Successfully";
    }
}