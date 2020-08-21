package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.DoctorRepository;
import com.ereceipt.demo.dao.PrescriptionRepository;
import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {
    private final DoctorRepository doctorRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public DoctorService(DoctorRepository doctorRepository, PrescriptionRepository prescriptionRepository) {
        this.doctorRepository = doctorRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Optional<Doctor> findDoctorByUsername(String username){
        return doctorRepository.findDoctorByUsername(username);
    }

    public Doctor findDoctorByUsernameAndPassword(String username,String password){
        return doctorRepository.findDoctorByUsernameAndPassword(username,password);
    }

    public List<Doctor> findAllDoctors(){
        return doctorRepository.findAll();
    }


    public Doctor saveNewDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }

    public Prescription addNewPrescription(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }


}
