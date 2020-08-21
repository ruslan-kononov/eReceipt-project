package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
    Prescription findByPrescrCode(String code);
    Prescription findByPrescrId(Long id);
}
