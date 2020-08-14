package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.DoctorRepository;
import com.ereceipt.demo.domain.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor findDoctorByUsernameAndPassword(String username,String password){
        return doctorRepository.findDoctorByUsernameAndPassword(username,password);
    }
}
