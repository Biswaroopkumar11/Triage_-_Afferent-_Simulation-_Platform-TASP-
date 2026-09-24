package com.medix.ai_medical_as.dto;

public class FacilityDistanceResponse {

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
    private Double distanceKm;

    public FacilityDistanceResponse() {
    }

    public FacilityDistanceResponse(
            Long id,
            String name,
            String facilityType,
            String address,
            String city,
            String district,
            String state,
            String pincode,
            Double latitude,
            Double longitude,
            String phone,
            Boolean isPublic,
            Boolean isActive,
            Double distanceKm
    ) {
        this.id = id;
        this.name = name;
        this.facilityType = facilityType;
        this.address = address;
        this.city = city;
        this.district = district;
        this.state = state;
        this.pincode = pincode;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
        this.isPublic = isPublic;
        this.isActive = isActive;
        this.distanceKm = distanceKm;
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

    public Double getDistanceKm() {
        return distanceKm;
    }
}