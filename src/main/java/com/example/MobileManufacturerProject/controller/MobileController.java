package com.example.MobileManufacturerProject.controller;

import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mobile")
public class MobileController {
    private final MobileService mobileService;

    @GetMapping("/{id}")
    public MobileDetails getMobileById(@PathVariable Long id) {
        return mobileService.getMobileById(id);
    }
}
