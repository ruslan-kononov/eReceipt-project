package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital,Long> {
    List<Hospital> findAll();
}
