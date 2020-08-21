package com.ereceipt.demo.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "doctors")
public class Doctor extends User{

    @ManyToOne
    @JoinColumn(name="hospital_id")
    private Hospital hospital;
    @OneToMany(mappedBy="doctor")
    private Set<Patient> patients = new HashSet<>();
    @OneToMany(mappedBy="doctor")
    private Set<Prescription> prescriptions = new HashSet<>();

    public Doctor(String username, String password, String firstName, String lastName,
                  String email, UserRole role, String photoId, Hospital hospital) {
        super(username, password, firstName, lastName, email, role, photoId);
        this.hospital = hospital;
    }

    public Doctor(String username, String password, String firstName, String lastName,
                  String email, UserRole role, String photoId) {
        super(username, password, firstName, lastName, email, role, photoId);
    }

    public Doctor() {
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Set<Patient> getPatients() {
        return patients;
    }

    public void setPatients(Set<Patient> patients) {
        this.patients = patients;
    }

    public Set<Prescription> getPrescriptions() {
        return prescriptions;
    }

    public void setPrescriptions(Set<Prescription> prescriptions) {
        this.prescriptions = prescriptions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Doctor doctor = (Doctor) o;
        return Objects.equals(hospital, doctor.hospital) &&
                Objects.equals(patients, doctor.patients) &&
                Objects.equals(prescriptions, doctor.prescriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hospital, patients, prescriptions);
    }
}
