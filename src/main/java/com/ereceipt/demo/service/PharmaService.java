package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.PharmacistRepository;
import com.ereceipt.demo.domain.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmaService {
    @Autowired
    PharmacistRepository pharmacistRepository;

    public Pharmacist findPharmacistByUsernameAndPassword(String username,String password){
        return pharmacistRepository.findPharmacistByUsernameAndPassword(username,password);
    }

}
