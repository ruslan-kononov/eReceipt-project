package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.PatientRepository;
import com.ereceipt.demo.domain.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public Patient addNewPatient(Patient patient){
        return patientRepository.save(patient);
    }

}
