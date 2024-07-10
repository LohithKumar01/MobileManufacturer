package com.example.MobileManufacturerProject.service;

import com.example.MobileManufacturerProject.entity.Mobile;
import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.repository.MobileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MobileService {

    private final MobileRepository mobileRepository;

    public MobileDetails getMobileById(Long id) {
        Mobile mobileById = mobileRepository.findById(id).orElse(null);
        if (mobileById == null) {
            throw new RuntimeException("Mobile Record Not In DB");
        }
        MobileDetails mobileDetails = new MobileDetails();
        BeanUtils.copyProperties(mobileById, mobileDetails);
        return mobileDetails;
    }
}
