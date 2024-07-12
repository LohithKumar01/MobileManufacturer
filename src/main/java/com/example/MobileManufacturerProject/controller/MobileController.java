package com.example.MobileManufacturerProject.controller;

import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mobile")
public class MobileController {
    private final MobileService mobileService;

    @GetMapping("/{id}")
    public MobileDetails getMobileById(@PathVariable Long id) {
        return mobileService.getMobileById(id);
    }

    @GetMapping("/list")
    public List<MobileDetails> getMobileDetailsList() {
        return mobileService.getMobileDetailsList();
    }

    @DeleteMapping("delete/{id}")
    public String deleteMobileById(@PathVariable Long id) {
        mobileService.deleteMobile(id);
        return "Record Deleted from DB";
    }

    @PostMapping("/create")
    public MobileDetails createMobile(@RequestBody MobileDetails mobileDetails) {
        return mobileService.saveMobile(mobileDetails);
    }

    @PutMapping("/update")
    public MobileDetails updateMobile(@RequestParam Long id, @RequestBody MobileDetails mobileDetails) {
        return mobileService.updateMobile(id, mobileDetails);
    }
}
