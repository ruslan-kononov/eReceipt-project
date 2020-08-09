package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PharmacistRepository extends JpaRepository<Pharmacist, UUID> {
}
