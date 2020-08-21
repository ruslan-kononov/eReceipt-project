package com.ereceipt.demo.domain;

import com.ereceipt.demo.dao.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class Support {

    @Autowired
    AdminRepository adminRepository;

    public Support() {
    }

    @PostConstruct
    public void init(){
//        Hospital defaultHospital = new Hospital("Charité – Universitätsmedizin Berlin");
//        hospitalRepository.save(defaultHospital);
//        Admin admin = new Admin("admin","admin","Vasia","Pupkin","pupkin@gmail.com",
//                UserRole.ADMIN,null, LocalDate.now());
//        adminRepository.save(admin);

    }
}
