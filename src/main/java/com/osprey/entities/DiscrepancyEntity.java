package com.osprey.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity(name = "Discrepancies")
@Table(name = "discrepancies")
public class DiscrepancyEntity {

    @Id
    @SequenceGenerator(name = "discrepancy_sequence", sequenceName = "discrepancy_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "discrepancy_sequence")
    private Long discrepancyID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = AircraftEntity.class)
    @JoinColumn(name = "id")
    private AircraftEntity aircraft;

    @Column(name = "discrepancy_title", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String discrepancyTitle;

    @Column(name = "discrepancy_description", updatable = true, nullable = false, columnDefinition = "TEXT")
    private String discrepancyDescription;

    @Column(name = "active", updatable = true, nullable = false)
    private boolean active = false;

    public DiscrepancyEntity() {

    }

    public DiscrepancyEntity(String discrepancyTitle, String discrepancyDescription, boolean active,
            AircraftEntity aircraft) {
        this.discrepancyTitle = discrepancyTitle;
        this.discrepancyDescription = discrepancyDescription;
        this.active = active;
        this.aircraft = aircraft;
    }

    public AircraftEntity getAircraft() {
        return aircraft;
    }

    public void setAircraft(AircraftEntity aircraft) {
        this.aircraft = aircraft;
    }

    public Long getDiscrepancyID() {
        return discrepancyID;
    }

    public void setDiscrepancyID(Long discrepancyID) {
        this.discrepancyID = discrepancyID;
    }

    public String getTitle() {
        return discrepancyTitle;
    }

    public void setTitle(String title) {
        this.discrepancyTitle = title;
    }

    public String getDiscrepancyDescription() {
        return discrepancyDescription;
    }

    public void setDiscrepancyDescription(String discrepancyDescription) {
        this.discrepancyDescription = discrepancyDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
