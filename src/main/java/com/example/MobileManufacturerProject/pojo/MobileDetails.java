package com.example.MobileManufacturerProject.pojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MobileDetails {
    private Long id;
    private String name;
    private double price;
    private String color;
}
