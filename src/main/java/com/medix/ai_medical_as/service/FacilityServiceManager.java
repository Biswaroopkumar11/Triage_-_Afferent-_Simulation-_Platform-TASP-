package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.dto.FacilityServiceRequest;
import com.medix.ai_medical_as.dto.FacilityServiceResponse;
import com.medix.ai_medical_as.entity.FacilityService;
import com.medix.ai_medical_as.entity.HealthcareFacility;
import com.medix.ai_medical_as.repository.FacilityServiceRepository;
import com.medix.ai_medical_as.repository.HealthcareFacilityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceManager {

    private final FacilityServiceRepository facilityServiceRepository;
    private final HealthcareFacilityRepository healthcareFacilityRepository;

    public FacilityServiceManager(
            FacilityServiceRepository facilityServiceRepository,
            HealthcareFacilityRepository healthcareFacilityRepository
    ) {
        this.facilityServiceRepository = facilityServiceRepository;
        this.healthcareFacilityRepository = healthcareFacilityRepository;
    }

    public FacilityServiceResponse addService(
            Long facilityId,
            FacilityServiceRequest request
    ) {

        HealthcareFacility facility =
                healthcareFacilityRepository.findById(facilityId)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Healthcare facility not found"
                                ));

        FacilityService service = new FacilityService();

        service.setFacility(facility);
        service.setServiceName(request.getServiceName());

        if (request.getAvailable() != null) {
            service.setAvailable(request.getAvailable());
        } else {
            service.setAvailable(true);
        }

        FacilityService savedService =
                facilityServiceRepository.save(service);

        return new FacilityServiceResponse(savedService);
    }

    public List<FacilityServiceResponse> getServicesByFacility(
            Long facilityId
    ) {

        healthcareFacilityRepository.findById(facilityId)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Healthcare facility not found"
                        ));

        return facilityServiceRepository
                .findByFacilityIdOrderByIdAsc(facilityId)
                .stream()
                .map(FacilityServiceResponse::new)
                .toList();
    }

    public List<FacilityServiceResponse> getFacilitiesByService(
            String serviceName
    ) {

        return facilityServiceRepository
                .findByServiceNameIgnoreCaseAndAvailableTrueOrderByIdAsc(
                        serviceName
                )
                .stream()
                .map(FacilityServiceResponse::new)
                .toList();
    }
}