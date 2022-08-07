package com.osprey.aircraft;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.osprey.discrepancy.Discrepancies;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

@Entity(name = "Aircraft")
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @SequenceGenerator(
            name="aircraft_sequence",
            sequenceName = "airacrft_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "aircraft_sequence"
    )
    @Column(
            name="id",
            updatable = false
    )
    private Long id;

    @Column(
            name="buno",
            updatable = true,
            nullable = false,
            length = 6,
            unique = true
    )
    private int buno;

    @Column(
            name="aircraft_type",
            updatable = true,
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String aircraftType;

    @Column(
            name = "aircraft_number",
            updatable = true,
            nullable = false,
            unique = true
    )
    private int aircraftNumber;

    @JsonManagedReference
    @OneToMany(targetEntity = Discrepancies.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "AircraftDiscrepancy_ForeignKey", referencedColumnName = "id")
    private List<Discrepancies> discrepancies;

    public Aircraft(){

    }

    public Aircraft(int buno, String aircraftType, List<Discrepancies> discrepancies, int aircraftNumber) {
        this.buno = buno;
        this.aircraftType = aircraftType;
        this.discrepancies = discrepancies;
        this.aircraftNumber = aircraftNumber;
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
