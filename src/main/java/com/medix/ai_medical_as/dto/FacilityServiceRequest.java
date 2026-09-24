package com.medix.ai_medical_as.dto;

public class FacilityServiceRequest {

    private String serviceName;
    private Boolean available;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}