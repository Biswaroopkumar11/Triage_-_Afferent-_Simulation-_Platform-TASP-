package com.medix.ai_medical_as.repository;

import com.medix.ai_medical_as.entity.HealthcareFacility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HealthcareFacilityRepository
        extends JpaRepository<HealthcareFacility, Long> {

    List<HealthcareFacility> findByIsActiveTrueOrderByIdAsc();

    List<HealthcareFacility> findByDistrictIgnoreCaseAndIsActiveTrueOrderByIdAsc(
            String district
    );
}