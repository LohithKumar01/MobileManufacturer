package com.example.MobileManufacturerProject.controller;

import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mobile")
public class MobileController {
    private final MobileService mobileService;
    Logger log = LoggerFactory.getLogger(MobileController.class);

    @GetMapping("/{id}")
    public MobileDetails getMobileById(@PathVariable Long id) {
        log.error("Mobile Record Fetch Error From DB");
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
        log.error("Error Creating New Mobile.");
        return mobileService.saveMobile(mobileDetails);
    }

    @PutMapping("/update")
    public MobileDetails updateMobile(@RequestParam Long id, @RequestBody MobileDetails mobileDetails) {
        log.error("Error Updating Mobile Details.");
        return mobileService.updateMobile(id, mobileDetails);
    }
}
