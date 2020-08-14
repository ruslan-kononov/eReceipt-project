package com.ereceipt.demo.domain;

import com.ereceipt.demo.dao.DoctorRepository;
import com.ereceipt.demo.dao.HospitalRepository;
import com.ereceipt.demo.dao.PharmacistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
@Component
public class Support {
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PharmacistRepository pharmacistRepository;
    @Autowired
    private HospitalRepository hospitalRepository;

    public Support() {
    }

    @PostConstruct
    public void init(){
        Hospital defaultHospital = new Hospital("Charité – Universitätsmedizin Berlin");
        hospitalRepository.save(defaultHospital);
        Hospital defaultHospital2 = hospitalRepository.findByName("Charité – Universitätsmedizin Berlin");
        Doctor defaultDoctor = new Doctor("Mark","Plank",defaultHospital2,"plank@gmail.con",
                "plank01","plank01");
        doctorRepository.save(defaultDoctor);
        Pharmacist defaultPharma = new Pharmacist("Laura","Stulz","stulz@gmail.com","stulz01",
                "stulz01",null);
        pharmacistRepository.save(defaultPharma);

    }

}
