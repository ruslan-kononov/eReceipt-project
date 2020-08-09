package com.ereceipt.demo.domain;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "patient_id", columnDefinition = "VARCHAR(255)")
    private UUID patientId;
    private String firstName;
    private String lastName;
    private int age;
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;
    @OneToMany(mappedBy="patient")
    private Set<Prescription> prescriptions = new HashSet<>();

    public Patient(String firstName, String lastName, int age, Doctor doctor) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.doctor = doctor;
    }

    public Patient() {
    }

    public UUID getPatientId() {
        return patientId;
    }

    public void setPatientId(UUID patientId) {
        this.patientId = patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
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
        Patient patient = (Patient) o;
        return age == patient.age &&
                Objects.equals(patientId, patient.patientId) &&
                Objects.equals(firstName, patient.firstName) &&
                Objects.equals(lastName, patient.lastName) &&
                Objects.equals(doctor, patient.doctor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(patientId, firstName, lastName, age, doctor);
    }
}
