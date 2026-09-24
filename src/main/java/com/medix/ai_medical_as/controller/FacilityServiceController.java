package com.medix.ai_medical_as.controller;

import com.medix.ai_medical_as.dto.FacilityServiceRequest;
import com.medix.ai_medical_as.dto.FacilityServiceResponse;
import com.medix.ai_medical_as.service.FacilityServiceManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityServiceController {

    private final FacilityServiceManager facilityServiceManager;

    public FacilityServiceController(
            FacilityServiceManager facilityServiceManager
    ) {
        this.facilityServiceManager = facilityServiceManager;
    }

    @PostMapping("/{facilityId}/services")
    public ResponseEntity<FacilityServiceResponse> addService(
            @PathVariable Long facilityId,
            @RequestBody FacilityServiceRequest request
    ) {

        FacilityServiceResponse response =
                facilityServiceManager.addService(
                        facilityId,
                        request
                );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/{facilityId}/services")
    public ResponseEntity<List<FacilityServiceResponse>> getServices(
            @PathVariable Long facilityId
    ) {

        return ResponseEntity.ok(
                facilityServiceManager.getServicesByFacility(facilityId)
        );
    }

    @GetMapping("/services/search")
    public ResponseEntity<List<FacilityServiceResponse>> searchByService(
            @RequestParam String service
    ) {

        return ResponseEntity.ok(
                facilityServiceManager.getFacilitiesByService(service)
        );
    }
}