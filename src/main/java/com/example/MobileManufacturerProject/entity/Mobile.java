package com.example.MobileManufacturerProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mobile")
@NoArgsConstructor
@AllArgsConstructor
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacturer_name")
    private String name;

    private double price;
    private String color;
}
