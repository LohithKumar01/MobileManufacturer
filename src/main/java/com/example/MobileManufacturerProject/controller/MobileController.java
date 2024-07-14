package com.example.MobileManufacturerProject.controller;

import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.service.MobileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mobile")
public class MobileController {
    private final MobileService mobileService;
    Logger log = LoggerFactory.getLogger(MobileController.class);

    @GetMapping("/{id}")
    public ResponseEntity<MobileDetails> getMobileById(@PathVariable Long id) {
        log.error("Mobile Record Fetch Error From DB");
        return new ResponseEntity<>(mobileService.getMobileById(id), HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<MobileDetails>> getMobileDetailsList() {
        return new ResponseEntity<>(mobileService.getMobileDetailsList(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteMobileById(@PathVariable Long id) {
        mobileService.deleteMobile(id);
        return new ResponseEntity<>("Record Deleted from DB", HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MobileDetails> createMobile(@RequestBody MobileDetails mobileDetails) {
        log.error("Error Creating New Mobile.");
        return new ResponseEntity<>(mobileService.saveMobile(mobileDetails), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MobileDetails> updateMobile(@RequestParam Long id, @RequestBody MobileDetails mobileDetails) {
        log.error("Error Updating Mobile Details.");
        return new ResponseEntity<>(mobileService.updateMobile(id, mobileDetails), HttpStatus.OK);
    }
}
