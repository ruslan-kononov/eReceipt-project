package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.HospitalRepository;
import com.ereceipt.demo.domain.Hospital;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HospitalService {

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalService(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    private Logger logger = LoggerFactory.getLogger(HospitalService.class);

    public List<Hospital> findAllHospitals(){
        logger.info("Get all hospitals");
        return hospitalRepository.findAll();
    }

    public Hospital addNewHospital(Hospital hospital){
        logger.info("Add new hospital {}",hospital);
        return hospitalRepository.save(hospital);
    }
}
