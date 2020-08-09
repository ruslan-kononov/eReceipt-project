package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PatientRepository extends JpaRepository<Patient, UUID> {
}
