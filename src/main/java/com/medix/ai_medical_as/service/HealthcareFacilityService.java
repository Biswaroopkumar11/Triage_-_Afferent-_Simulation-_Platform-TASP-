package com.medix.ai_medical_as.service;

import com.medix.ai_medical_as.dto.CreateFacilityRequest;
import com.medix.ai_medical_as.entity.HealthcareFacility;
import com.medix.ai_medical_as.repository.HealthcareFacilityRepository;
import org.springframework.stereotype.Service;
import com.medix.ai_medical_as.dto.CreateFacilityRequest;

import java.util.List;

@Service
public class HealthcareFacilityService {

    private final HealthcareFacilityRepository facilityRepository;

    public HealthcareFacilityService(
            HealthcareFacilityRepository facilityRepository
    ) {
        this.facilityRepository = facilityRepository;
    }

    public HealthcareFacility createFacility(
            CreateFacilityRequest request
    ) {

        HealthcareFacility facility = new HealthcareFacility();

        facility.setName(request.getName());
        facility.setFacilityType(request.getFacilityType());
        facility.setAddress(request.getAddress());
        facility.setCity(request.getCity());
        facility.setDistrict(request.getDistrict());
        facility.setState(request.getState());
        facility.setPincode(request.getPincode());
        facility.setLatitude(request.getLatitude());
        facility.setLongitude(request.getLongitude());
        facility.setPhone(request.getPhone());

        if (request.getIsPublic() != null) {
            facility.setIsPublic(request.getIsPublic());
        }

        return facilityRepository.save(facility);
    }

    public List<HealthcareFacility> getAllFacilities() {

        return facilityRepository
                .findByIsActiveTrueOrderByIdAsc();
    }

    public HealthcareFacility getFacilityById(Long id) {

        return facilityRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException(
                                "Healthcare facility not found with id: " + id
                        )
                );
    }

    public List<HealthcareFacility> getFacilitiesByDistrict(
            String district
    ) {

        return facilityRepository
                .findByDistrictIgnoreCaseAndIsActiveTrueOrderByIdAsc(
                        district
                );
    }
}