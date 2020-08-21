package com.ereceipt.demo.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import net.bytebuddy.utility.RandomString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "prescriptions")
public class Prescription{
    @Id
    @GeneratedValue
    private Long prescrId;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="patient_id", nullable=false)
    private Patient patient;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable=false)
    private Doctor doctor;
    private String medicineName;
    @Lob
    @Column(length=512)
    private String prescrText;
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private Date utilDate = new Date();
    @Column(columnDefinition = "boolean default false")
    private Boolean isHanded = false;
    @Column(columnDefinition = "VARCHAR(8)",nullable=false)
    private String prescrCode;

    public Prescription(Patient patient, Doctor doctor, String medicineName, String prescrText,String prescrCode) {
        this.patient = patient;
        this.doctor = doctor;
        this.medicineName = medicineName;
        this.prescrText = prescrText;
        this.prescrCode = prescrCode;
    }

    public Prescription() {
    }

    public Long getPrescrId() {
        return prescrId;
    }

    public void setPrescrId(Long prescrId) {
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

    public Boolean getHanded() {
        return isHanded;
    }

    public void setHanded(Boolean handed) {
        isHanded = handed;
    }

    public String getPrescrCode() {
        return prescrCode;
    }

    public void setPrescrCode(String prescrCode) {
        this.prescrCode = prescrCode;
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
                Objects.equals(utilDate, that.utilDate) &&
                Objects.equals(isHanded, that.isHanded) &&
                Objects.equals(prescrCode, that.prescrCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prescrId, patient, doctor, medicineName, prescrText, utilDate, isHanded, prescrCode);
    }
}
