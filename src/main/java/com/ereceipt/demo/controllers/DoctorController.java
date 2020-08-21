package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Prescription;
import com.ereceipt.demo.service.DoctorService;
import com.ereceipt.demo.service.PatientService;
import net.bytebuddy.utility.RandomString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final PatientService patientService;

    @Autowired
    public DoctorController(DoctorService doctorService,PatientService patientService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    @GetMapping("")
    public String getDoctorPage(Model model){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Doctor doctor = doctorService.findDoctorByUsernameAndPassword(userDetails.getUsername(),
                userDetails.getPassword());
        model.addAttribute("doctor",doctor);
        model.addAttribute("prescription",new Prescription());
        model.addAttribute("patients",doctor.getPatients());
        model.addAttribute("prescrCode", new RandomString().nextString());
        return "doctor";
    }

    @PostMapping("/addPrescription")
    public RedirectView addNewDoctor(@ModelAttribute("prescription") Prescription prescription, Model model){
        doctorService.addNewPrescription(prescription);
        return new RedirectView("/doctor",true);
    }
}
