package com.codingmart.vehiclecrudtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Long registerNo;

    @NotBlank
    private String model;

    @Min(1000)
    @Max(9999)
    private int purchasingYear;

    @NotNull
    private double price;

    @NotBlank
    private String vin;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_feature_id")
    private VehicleFeature vehicleFeature;
}