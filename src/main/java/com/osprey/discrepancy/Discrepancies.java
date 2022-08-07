package com.osprey.discrepancy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.osprey.aircraft.Aircraft;

import javax.persistence.*;

@Entity(name="Discrepancies")
@Table(name = "discrepancies")
public class Discrepancies {

    @Id
    @SequenceGenerator(
            name = "discrepancy_sequence",
            sequenceName = "discrepancy_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "discrepancy_sequence"
    )
    private Long discrepancyID;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Aircraft.class)
    @JoinColumn(name = "id")
    private Aircraft aircraft;

    @Column(
            name = "discrepancy_title",
            updatable = false,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String discrepancyTitle;

    @Column(
            name = "discrepancy_description",
            updatable =true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String discrepancyDescription;

    @Column(
            name="active",
            updatable = true,
            nullable = false
    )
    private boolean active = false;

    public Discrepancies(){

    }

    public Discrepancies(String discrepancyTitle, String discrepancyDescription, boolean active, Aircraft aircraft) {
        this.discrepancyTitle = discrepancyTitle;
        this.discrepancyDescription = discrepancyDescription;
        this.active = active;
        this.aircraft = aircraft;
    }

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
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
