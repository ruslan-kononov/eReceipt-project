package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DoctorRepository extends JpaRepository<Doctor, UUID> {

}
