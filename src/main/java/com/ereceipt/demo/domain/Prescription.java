package com.ereceipt.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "prescr_id", columnDefinition = "VARCHAR(255)")
    private UUID prescrId;
    @ManyToOne
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name="doctor_id", nullable=false)
    private Doctor doctor;
    private String medicineName;
    private String prescrText;
    @Temporal(TemporalType.TIMESTAMP)
    private Date utilDate;

    public Prescription(Patient patient, Doctor doctor, String medicineName, String prescrText) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicineName = medicineName;
        this.prescrText = prescrText;
    }

    public Prescription() {
    }

    public UUID getPrescrId() {
        return prescrId;
    }

    public void setPrescrId(UUID prescrId) {
        this.prescrId = prescrId;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getPrescrText() {
        return prescrText;
    }

    public void setPrescrText(String prescrText) {
        this.prescrText = prescrText;
    }

    public Date getUtilDate() {
        return utilDate;
    }

    public void setUtilDate(Date utilDate) {
        this.utilDate = utilDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prescription that = (Prescription) o;
        return Objects.equals(prescrId, that.prescrId) &&
                Objects.equals(patient, that.patient) &&
                Objects.equals(doctor, that.doctor) &&
                Objects.equals(medicineName, that.medicineName) &&
                Objects.equals(prescrText, that.prescrText) &&
                Objects.equals(utilDate, that.utilDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescrId, patient, doctor, medicineName, prescrText, utilDate);
    }
}
