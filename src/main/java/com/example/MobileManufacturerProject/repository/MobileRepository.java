package com.example.MobileManufacturerProject.repository;

import com.example.MobileManufacturerProject.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileRepository extends JpaRepository<Mobile, Long> {
}
