package com.codingmart.vehiclecrudtask.repository;

import com.codingmart.vehiclecrudtask.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {
}