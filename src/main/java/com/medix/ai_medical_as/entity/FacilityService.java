package com.medix.ai_medical_as.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "facility_services")
public class FacilityService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facility_id", nullable = false)
    private HealthcareFacility facility;

    @Column(name = "service_name", nullable = false)
    private String serviceName;

    @Column(nullable = false)
    private Boolean available = true;

    public FacilityService() {
    }

    public Long getId() {
        return id;
    }

    public HealthcareFacility getFacility() {
        return facility;
    }

    public void setFacility(HealthcareFacility facility) {
        this.facility = facility;
    }

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