package com.example.MobileManufacturerProject.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileDetails {
    private Long id;
    private String name;
    private double price;
    private String color;
}
