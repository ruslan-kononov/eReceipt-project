package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    @Query("select p from Patient p where p.doctor.userId=?1")
    List<Patient> findAllByAssignedDoctorId(UUID id);
}
