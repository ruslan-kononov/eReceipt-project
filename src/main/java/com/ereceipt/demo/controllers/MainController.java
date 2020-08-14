package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Pharmacist;
import com.ereceipt.demo.service.DoctorService;
import com.ereceipt.demo.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
    @Autowired
    DoctorService doctorService;
    @Autowired
    PharmaService pharmaService;

    @GetMapping("/doctor")
    public void getDoctorData(Model model){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Doctor doctor = doctorService.findDoctorByUsernameAndPassword(userDetails.getUsername(),
                userDetails.getPassword());
        model.addAttribute("doctor",doctor);
    }

    @GetMapping("/pharma")
    public void getPharmaData(Model model){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Pharmacist pharma = pharmaService.findPharmacistByUsernameAndPassword(userDetails.getUsername(),
                userDetails.getPassword());
        model.addAttribute("pharma",pharma);
    }
}
