package com.codingmart.vehiclecrudtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class VehicleFeature {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String color;

    @Min(0)
    private int mileage;

    @NotBlank
    private String fuelType;

    private boolean isAutomaticTransmission;

    @NotBlank
    private String transmissionType;
}