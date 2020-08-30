package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.DoctorRepository;
import com.ereceipt.demo.dao.PrescriptionRepository;
import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PrescriptionRepository prescriptionRepository;

    private Logger logger = LoggerFactory.getLogger(DoctorService.class);

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, PrescriptionRepository prescriptionRepository) {
        this.doctorRepository = doctorRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Optional<Doctor> findDoctorByUsername(String username){
        logger.info("Get doctor by username {}",username);
        return doctorRepository.findDoctorByUsername(username);
    }

    public Doctor findDoctorByUsernameAndPassword(String username,String password){
        logger.info("Get doctor by username {} and password {}",password,username);
        return doctorRepository.findDoctorByUsernameAndPassword(username,password);
    }

    public List<Doctor> findAllDoctors(){
        logger.info("Get all doctors");
        return doctorRepository.findAll();
    }

    public Doctor saveNewDoctor(Doctor doctor){
        logger.info("Add new doctor {}",doctor);
        return doctorRepository.save(doctor);
    }

    public Prescription addNewPrescription(Prescription prescription){
        logger.info("Add new prescription {}",prescription);
        return prescriptionRepository.save(prescription);
    }
}
