package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PharmacistRepository extends JpaRepository<Pharmacist, UUID> {
    public Pharmacist findByUsername(String username);
    public Pharmacist findPharmacistByUsernameAndPassword(String username, String password);
}
