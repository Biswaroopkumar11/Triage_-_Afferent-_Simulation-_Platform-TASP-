package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.dto.CreateFacilityRequest;
import com.medix.ai_medical_as.dto.FacilityResponse;
import com.medix.ai_medical_as.entity.HealthcareFacility;
import com.medix.ai_medical_as.service.HealthcareFacilityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class HealthcareFacilityController {

    private final HealthcareFacilityService facilityService;

    public HealthcareFacilityController(
            HealthcareFacilityService facilityService
    ) {
        this.facilityService = facilityService;
    }

    @PostMapping
    public ResponseEntity<FacilityResponse> createFacility(
            @RequestBody CreateFacilityRequest request
    ) {

        HealthcareFacility facility =
                facilityService.createFacility(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new FacilityResponse(facility));
    }

    @GetMapping
    public ResponseEntity<List<FacilityResponse>> getAllFacilities() {

        List<FacilityResponse> response =
                facilityService.getAllFacilities()
                        .stream()
                        .map(FacilityResponse::new)
                        .toList();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacilityResponse> getFacility(
            @PathVariable Long id
    ) {

        HealthcareFacility facility =
                facilityService.getFacilityById(id);

        FacilityResponse response =
                new FacilityResponse(facility);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/district/{district}")
    public ResponseEntity<List<FacilityResponse>> getByDistrict(
            @PathVariable String district
    ) {

        List<FacilityResponse> response =
                facilityService
                        .getFacilitiesByDistrict(district)
                        .stream()
                        .map(FacilityResponse::new)
                        .toList();

        return ResponseEntity.ok(response);
    }
}