package com.example.MobileManufacturerProject.service;

import com.example.MobileManufacturerProject.entity.Mobile;
import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.repository.MobileRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class MobileServiceTest {

    @Mock
    private MobileRepository mobileRepository;
    @InjectMocks
    private MobileService mobileService;

    @Test
    void testGetMobileById() {
        Mobile mobile = new Mobile();
        mobile.setId(1L);
        mobile.setName("Samsung");
        mobile.setPrice(299.99);
        mobile.setColor("Black");

        when(mobileRepository.findById(1L)).thenReturn(Optional.of(mobile));

        MobileDetails getMobileById = mobileService.getMobileById(1L);

        Assertions.assertNotNull(getMobileById);
        Assertions.assertEquals("Samsung", getMobileById.getName());
        Assertions.assertEquals(299.99, getMobileById.getPrice(), 0.01);

    }

    @Test
    void testSaveMobile() {
        Mobile mobile = new Mobile();
        mobile.setId(2L);
        mobile.setName("iPhone");
        mobile.setPrice(1099.99);
        mobile.setColor("Titanium");

        MobileDetails mobileDetails = new MobileDetails();
        mobileDetails.setName("iPhone");
        mobileDetails.setPrice(1099.99);
        mobileDetails.setColor("Titanium");

        when(mobileRepository.save(any(Mobile.class))).thenReturn(mobile);

        MobileDetails saveMobileDetails = mobileService.saveMobile(mobileDetails);

        Assertions.assertNotNull(saveMobileDetails);
        Assertions.assertEquals(2L, saveMobileDetails.getId());
        Assertions.assertEquals("iPhone", saveMobileDetails.getName());
    }
}