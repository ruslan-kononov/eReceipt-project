package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    List<Hospital> findAll();
    Hospital findByName(String name);
}
