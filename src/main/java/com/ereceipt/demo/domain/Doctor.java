package com.ereceipt.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class Doctor{
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "doctor_id", columnDefinition = "VARCHAR(255)")
    private UUID doctorId;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name="hospital_id", nullable=false)
    private Hospital hospital;
    private String email;
    private String username;
    private String password;
    private String photoId;
    @OneToMany(mappedBy="doctor")
    private Set<Patient> patients = new HashSet<>();
    @OneToMany(mappedBy="doctor")
    private Set<Prescription> prescriptions = new HashSet<>();

    public Doctor(String firstName, String lastName, Hospital hospital, String email,
                  String password, String photoId, String username) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hospital = hospital;
        this.email = email;
        this.password = password;
        this.photoId = photoId;
        this.username = username;
    }

    public Doctor() {
    }

    public UUID getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(UUID doctorId) {
        this.doctorId = doctorId;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
        return Objects.equals(doctorId, doctor.doctorId) &&
                Objects.equals(firstName, doctor.firstName) &&
                Objects.equals(lastName, doctor.lastName) &&
                Objects.equals(hospital, doctor.hospital) &&
                Objects.equals(email, doctor.email) &&
                Objects.equals(username, doctor.username) &&
                Objects.equals(password, doctor.password) &&
                Objects.equals(photoId, doctor.photoId) &&
                Objects.equals(patients, doctor.patients) &&
                Objects.equals(prescriptions, doctor.prescriptions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doctorId, firstName, lastName, hospital, email, username, password, photoId, patients, prescriptions);
    }
}
