package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.PatientRepository;
import com.ereceipt.demo.domain.Patient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {
    private final PatientRepository patientRepository;

    private Logger logger = LoggerFactory.getLogger(PatientService.class);

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addNewPatient(Patient patient){
        logger.info("Add new patient {} :"+patient);
        return patientRepository.save(patient);
    }

}
