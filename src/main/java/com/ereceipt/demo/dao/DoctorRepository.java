package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, UUID> {
    Optional<Doctor> findDoctorByUsername(String username);
    Doctor findDoctorByUsernameAndPassword(String username,String password);
}
