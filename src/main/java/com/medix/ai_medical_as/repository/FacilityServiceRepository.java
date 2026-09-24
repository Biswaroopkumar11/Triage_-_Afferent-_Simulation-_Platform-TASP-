package com.medix.ai_medical_as.repository;

import com.medix.ai_medical_as.entity.FacilityService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityServiceRepository
        extends JpaRepository<FacilityService, Long> {

    List<FacilityService> findByFacilityIdOrderByIdAsc(
            Long facilityId
    );

    List<FacilityService>
    findByServiceNameIgnoreCaseAndAvailableTrueOrderByIdAsc(
            String serviceName
    );
}