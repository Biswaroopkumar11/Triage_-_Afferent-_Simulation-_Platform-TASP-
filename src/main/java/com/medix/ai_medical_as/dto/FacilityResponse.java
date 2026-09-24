package com.medix.ai_medical_as.dto;

import com.medix.ai_medical_as.entity.HealthcareFacility;

public class FacilityResponse {

    private Long id;
    private String name;
    private String facilityType;
    private String address;
    private String city;
    private String district;
    private String state;
    private String pincode;
    private Double latitude;
    private Double longitude;
    private String phone;
    private Boolean isPublic;
    private Boolean isActive;

    public FacilityResponse(HealthcareFacility facility) {
        this.id = facility.getId();
        this.name = facility.getName();
        this.facilityType = facility.getFacilityType();
        this.address = facility.getAddress();
        this.city = facility.getCity();
        this.district = facility.getDistrict();
        this.state = facility.getState();
        this.pincode = facility.getPincode();
        this.latitude = facility.getLatitude();
        this.longitude = facility.getLongitude();
        this.phone = facility.getPhone();
        this.isPublic = facility.getIsPublic();
        this.isActive = facility.getIsActive();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFacilityType() {
        return facilityType;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public Boolean getIsActive() {
        return isActive;
    }
}