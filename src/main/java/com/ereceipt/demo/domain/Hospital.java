package com.ereceipt.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue
    @Column(name = "hospital_id")
    private Long hospitalId;
    private String name;
    @OneToMany(mappedBy="hospital")
    private Set<Doctor> doctors = new HashSet<>();

    public Hospital(String name) {
        this.name = name;
    }

    public Hospital() {
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(Set<Doctor> doctors) {
        this.doctors = doctors;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return Objects.equals(hospitalId, hospital.hospitalId) &&
                Objects.equals(name, hospital.name) &&
                Objects.equals(doctors, hospital.doctors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospitalId, name, doctors);
    }
}
