package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.PharmacistRepository;
import com.ereceipt.demo.dao.PrescriptionRepository;
import com.ereceipt.demo.domain.Pharmacist;
import com.ereceipt.demo.domain.Prescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmaService {

    private final PharmacistRepository pharmacistRepository;
    private final PrescriptionRepository prescriptionRepository;

    @Autowired
    public PharmaService(PharmacistRepository pharmacistRepository,
                         PrescriptionRepository prescriptionRepository) {
        this.pharmacistRepository = pharmacistRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Pharmacist findPharmacistByUsernameAndPassword(String username, String password){
        return pharmacistRepository.findPharmacistByUsernameAndPassword(username,password);
    }

    public Pharmacist findPharmacistByUsername(String username){
        return pharmacistRepository.findByUsername(username);
    }

    public Prescription findPrescriptionByItsCode(String code){
        return prescriptionRepository.findByPrescrCode(code);
    }

    public Prescription findPrescriptionById(Long id){
        return prescriptionRepository.findByPrescrId(id);
    }

    public Prescription savePrescription(Prescription prescription){
        return prescriptionRepository.save(prescription);
    }

    public Pharmacist addNewPharmacist(Pharmacist pharmacist){
        return pharmacistRepository.save(pharmacist);
    }





}
