package com.medix.ai_medical_as.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "healthcare_facilities")
public class HealthcareFacility {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "facility_type")
    private String facilityType;

    private String address;

    private String city;

    private String district;

    private String state;

    private String pincode;

    private Double latitude;

    private Double longitude;

    private String phone;

    @Column(name = "is_public")
    private Boolean isPublic = true;

    @Column(name = "is_active")
    private Boolean isActive = true;

    public HealthcareFacility() {
    }

    // ---------- GETTERS ----------

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

    // ---------- SETTERS ----------

    public void setName(String name) {
        this.name = name;
    }

    public void setFacilityType(String facilityType) {
        this.facilityType = facilityType;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}