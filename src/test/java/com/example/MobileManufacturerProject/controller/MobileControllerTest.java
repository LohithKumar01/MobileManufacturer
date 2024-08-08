package com.example.MobileManufacturerProject.controller;

import com.example.MobileManufacturerProject.pojo.MobileDetails;
import com.example.MobileManufacturerProject.service.MobileService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MobileController.class)
public class MobileControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MobileService mobileService;


    @Test
    public void testGetMobileById() throws Exception {
        MobileDetails mobileDetails = new MobileDetails(1L, "Samsung", 299.99, "Black");
        given(mobileService.getMobileById(anyLong())).willReturn(mobileDetails);

        mockMvc.perform(get("http://localhost:8084/api/mobile/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Samsung")))
                .andExpect(jsonPath("$.price", is(299.99)))
                .andExpect(jsonPath("$.color", is("Black")));
    }

    @Test
    public void testSaveMobile() throws Exception {
        MobileDetails mobileDetails = new MobileDetails();
        mobileDetails.setId(1L);
        mobileDetails.setName("Samsung");
        mobileDetails.setPrice(299.99);
        mobileDetails.setColor("Black");

        when(mobileService.saveMobile(any(MobileDetails.class))).thenReturn(mobileDetails);

        mockMvc.perform(post("http://localhost:8084/api/mobile/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(mobileDetails)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.name", is("Samsung")))
                .andExpect(jsonPath("$.price", is(299.99)))
                .andExpect(jsonPath("$.color", is("Black")));
    }

    @Test
    public void testDeleteMobile() throws Exception {
        doNothing().when(mobileService).deleteMobile(anyLong());

        mockMvc.perform(delete("http://localhost:8084/api/mobile/delete/4")).andExpect(status().isOk());
    }
}
