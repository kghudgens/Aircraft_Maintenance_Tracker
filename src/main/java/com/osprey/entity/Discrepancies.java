package com.osprey.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Discrepancies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long discrepancyID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id")
    private Aircraft aircraft;

    @NotNull
    private String title;

    @NotNull
    private String discrepancyDescription;

    @NotNull
    @Column(name="Active", nullable = false)
    private boolean active = false;

    public Aircraft getAircraft() {
        return aircraft;
    }

    public void setAircraft(Aircraft aircraft) {
        this.aircraft = aircraft;
    }

    public Discrepancies(){

    }

    public Discrepancies(Long discrepancyID, String title, String discrepancyDescription, boolean active) {
        this.discrepancyID = discrepancyID;
        this.title = title;
        this.discrepancyDescription = discrepancyDescription;
        this.active = active;
    }

    public Long getDiscrepancyID() {
        return discrepancyID;
    }

    public void setDiscrepancyID(Long discrepancyID) {
        this.discrepancyID = discrepancyID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
