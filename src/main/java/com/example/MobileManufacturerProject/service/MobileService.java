package com.example.MobileManufacturerProject.service;

import com.example.MobileManufacturerProject.controller.MobileController;
import com.example.MobileManufacturerProject.entity.Mobile;
import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MobileService {

    private final MobileRepository mobileRepository;

    Logger log = LoggerFactory.getLogger(MobileService.class);

    public MobileDetails getMobileById(Long id) {
        Mobile mobileById = mobileRepository.findById(id).orElse(null);
        if (mobileById == null) {
            throw new RuntimeException("Mobile Record Not In DB");
        }
        MobileDetails mobileDetails = new MobileDetails();
        BeanUtils.copyProperties(mobileById, mobileDetails);
        log.info("Mobile Details Fetched Successfully.");
        return mobileDetails;
    }

    public List<MobileDetails> getMobileDetailsList() {
        List<Mobile> mobileList = mobileRepository.findAll();
        List<MobileDetails> mobileDetailsList = new ArrayList<>();
        mobileList.stream().forEach(mobile -> {
            MobileDetails mobileDetails = new MobileDetails();
            BeanUtils.copyProperties(mobile, mobileDetails);
            mobileDetailsList.add(mobileDetails);
        });
        log.info("Mobile Details List Fetched Successfully.");
        return mobileDetailsList;
    }

    public void deleteMobile(Long id) {
        mobileRepository.deleteById(id);
    }

    public MobileDetails saveMobile(MobileDetails mobileDetails) {
        Mobile createMobile = new Mobile();
        createMobile.setName(mobileDetails.getName());
        createMobile.setPrice(mobileDetails.getPrice());
        createMobile.setColor(mobileDetails.getColor());

        Mobile savedMobile = mobileRepository.save(createMobile);
        BeanUtils.copyProperties(savedMobile, mobileDetails);
        log.info("New Mobile Created Successfully.");
        return mobileDetails;
    }

    public MobileDetails updateMobile(Long id, MobileDetails mobileDetails) {
        Mobile mobileUpdateById = mobileRepository.findById(id).orElse(null);
        if (mobileUpdateById == null) {
            throw new RuntimeException("Mobile Record Not Found.");
        }
        mobileUpdateById.setName(mobileDetails.getName());
        mobileUpdateById.setPrice(mobileDetails.getPrice());
        mobileUpdateById.setColor(mobileDetails.getColor());
        Mobile updatedMobile = mobileRepository.save(mobileUpdateById);
        MobileDetails updatedMobileDetails = new MobileDetails();
        BeanUtils.copyProperties(updatedMobile, updatedMobileDetails);
        log.info("Updated Mobile Details.");
        return updatedMobileDetails;
    }
}
