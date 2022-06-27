package com.osprey.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Discrepancies {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long discrepancyID;

    @NotNull
    private String title;

    @NotNull
    private String discrepancyDescription;

    @NotNull
    @OneToOne(targetEntity = Aircraft.class)
    private int assignedAircraft;

    @NotNull
    @Column(name="Active", nullable = false)
    private boolean active = false;

    public Discrepancies(){

    }

    public Discrepancies(Long discrepancyID, String title, String discrepancyDescription, int assignedAircraft, boolean active) {
        this.discrepancyID = discrepancyID;
        this.title = title;
        this.discrepancyDescription = discrepancyDescription;
        this.assignedAircraft = assignedAircraft;
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

    public int getAssignedAircraft() {
        return assignedAircraft;
    }

    public void setAssignedAircraft(int assignedAircraft) {
        this.assignedAircraft = assignedAircraft;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
