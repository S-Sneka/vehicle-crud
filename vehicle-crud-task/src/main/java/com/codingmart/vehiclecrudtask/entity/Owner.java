package com.codingmart.vehiclecrudtask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @Email(message = "Please provide a valid email address")
    private String email;

    @NotBlank
    @Size(min = 7, message = "Phone number must be at least 7 characters")
    private String phoneNumber;

    @NotBlank
    private String address;
}