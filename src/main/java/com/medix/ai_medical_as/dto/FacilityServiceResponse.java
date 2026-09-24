package com.medix.ai_medical_as.dto;

import com.medix.ai_medical_as.entity.FacilityService;

public class FacilityServiceResponse {

    private Long id;
    private Long facilityId;
    private String serviceName;
    private Boolean available;

    public FacilityServiceResponse() {
    }

    public FacilityServiceResponse(FacilityService service) {
        this.id = service.getId();
        this.facilityId = service.getFacility().getId();
        this.serviceName = service.getServiceName();
        this.available = service.getAvailable();
    }

    public Long getId() {
        return id;
    }

    public Long getFacilityId() {
        return facilityId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public Boolean getAvailable() {
        return available;
    }
}