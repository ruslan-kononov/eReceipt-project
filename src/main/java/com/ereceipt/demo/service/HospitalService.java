package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.HospitalRepository;
import com.ereceipt.demo.domain.Hospital;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {
    @Autowired
    HospitalRepository hospitalRepository;

    public List<Hospital> findAllHospitals(){
        return hospitalRepository.findAll();
    }

    public Hospital addNewHospital(Hospital hospital){
        return hospitalRepository.save(hospital);
    }
}
