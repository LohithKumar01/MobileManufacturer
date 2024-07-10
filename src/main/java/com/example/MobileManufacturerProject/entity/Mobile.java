package com.example.MobileManufacturerProject.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "mobile")
public class Mobile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "manufacturer_name")
    private String name;

    private double price;
    private String color;
}
