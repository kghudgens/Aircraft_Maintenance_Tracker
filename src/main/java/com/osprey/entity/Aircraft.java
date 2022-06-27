package com.osprey.entity;

import com.osprey.entity.Discrepancies;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity
@Table(name="aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Column(name="buno", length = 6)
    @Pattern(regexp ="^[0-9]*$", message = "A Buno is a 6 digit number that represents the aircraft")
    private int buno;

    @NotNull
    private String aircraftType;

    @OneToMany(targetEntity = Discrepancies.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "AircraftDiscrepancy_ForeignKey", referencedColumnName = "buno")
    private List<Discrepancies> discrepancies;

    public Aircraft(){

    }

    public Aircraft(int buno, String aircraftType, List<Discrepancies> discrepancies) {
        this.buno = buno;
        this.aircraftType = aircraftType;
        this.discrepancies = discrepancies;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBuno() {
        return buno;
    }

    public void setBuno(int buno) {
        this.buno = buno;
    }

    public String getAircraftType() {
        return aircraftType;
    }

    public void setAircraftType(String aircraftType) {
        this.aircraftType = aircraftType;
    }

    public List<Discrepancies> getDiscrepancies() {
        return discrepancies;
    }

    public void setDiscrepancies(List<Discrepancies> discrepancies) {
        this.discrepancies = discrepancies;
    }
}
