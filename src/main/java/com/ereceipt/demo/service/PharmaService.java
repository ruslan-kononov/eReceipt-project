package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.PharmacistRepository;
import com.ereceipt.demo.dao.PrescriptionRepository;
import com.ereceipt.demo.domain.Pharmacist;
import com.ereceipt.demo.domain.Prescription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmaService {

    private final PharmacistRepository pharmacistRepository;
    private final PrescriptionRepository prescriptionRepository;

    private Logger logger = LoggerFactory.getLogger(PharmaService.class);

    @Autowired
    public PharmaService(PharmacistRepository pharmacistRepository,
                         PrescriptionRepository prescriptionRepository) {
        this.pharmacistRepository = pharmacistRepository;
        this.prescriptionRepository = prescriptionRepository;
    }

    public Pharmacist findPharmacistByUsernameAndPassword(String username, String password){
        logger.info("Get pharmacist by username '"+username+"' and password '"+password+"'");
        return pharmacistRepository.findPharmacistByUsernameAndPassword(username,password);
    }

    public Pharmacist findPharmacistByUsername(String username){
        logger.info("Get pharmacist by username '"+username+"'");
        return pharmacistRepository.findByUsername(username);
    }

    public Prescription findPrescriptionByItsCode(String code){
        logger.info("Get prescription by code '"+code+"'");
        return prescriptionRepository.findByPrescrCode(code);
    }

    public Prescription findPrescriptionById(Long id){
        logger.info("Get prescription by id '"+id+"'");
        return prescriptionRepository.findByPrescrId(id);
    }

    public Prescription savePrescription(Prescription prescription){
        logger.info("Add new prescription {} :"+prescription);
        return prescriptionRepository.save(prescription);
    }

    public Pharmacist addNewPharmacist(Pharmacist pharmacist){
        logger.info("Add new pharmacist {} :"+pharmacist);
        return pharmacistRepository.save(pharmacist);
    }
}
