package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Hospital;
import com.ereceipt.demo.domain.Patient;
import com.ereceipt.demo.domain.Pharmacist;
import com.ereceipt.demo.service.DoctorService;
import com.ereceipt.demo.service.HospitalService;
import com.ereceipt.demo.service.PatientService;
import com.ereceipt.demo.service.PharmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("admin")
public class AdminController {

    private final DoctorService doctorService;
    private final PharmaService pharmaService;
    private final HospitalService hospitalService;
    private final PatientService patientService;

    @Autowired
    public AdminController(DoctorService doctorService, PharmaService pharmaService,
                           HospitalService hospitalService, PatientService patientService) {
        this.doctorService = doctorService;
        this.pharmaService = pharmaService;
        this.hospitalService = hospitalService;
        this.patientService = patientService;
    }

    @GetMapping("")
    public String getAdminPage(Model model){
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("pharma", new Pharmacist());
        model.addAttribute("hospitals",hospitalService.findAllHospitals());
        model.addAttribute("doctors",doctorService.findAllDoctors());
        return "admin";
    }

    @PostMapping("/addDoctor")
    public RedirectView addNewDoctor(@ModelAttribute("doctor") Doctor doctor,Model model){
        doctorService.saveNewDoctor(doctor);
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("pharma", new Pharmacist());
        model.addAttribute("hospitals",hospitalService.findAllHospitals());
        model.addAttribute("doctors",doctorService.findAllDoctors());
        return new RedirectView("/admin",true);
    }

    @PostMapping("/addPharma")
    public RedirectView addNewPharmacist(@ModelAttribute("pharma") Pharmacist pharmacist,Model model){
        pharmaService.addNewPharmacist(pharmacist);
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("pharma", new Pharmacist());
        model.addAttribute("hospitals",hospitalService.findAllHospitals());
        model.addAttribute("doctors",doctorService.findAllDoctors());
        return new RedirectView("/admin",true);
    }

    @PostMapping("/addHospital")
    public RedirectView addNewHospital(@ModelAttribute("hospital") Hospital hospital, Model model){
        hospitalService.addNewHospital(hospital);
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("pharma", new Pharmacist());
        model.addAttribute("hospitals",hospitalService.findAllHospitals());
        model.addAttribute("doctors",doctorService.findAllDoctors());
        return new RedirectView("/admin",true);
    }

    @PostMapping("/addPatient")
    public RedirectView addNewPatient(@ModelAttribute("patient") Patient patient, Model model){
        patientService.addNewPatient(patient);
        model.addAttribute("patient",new Patient());
        model.addAttribute("hospital", new Hospital());
        model.addAttribute("doctor", new Doctor());
        model.addAttribute("pharma", new Pharmacist());
        model.addAttribute("hospitals",hospitalService.findAllHospitals());
        model.addAttribute("doctors",doctorService.findAllDoctors());
        return new RedirectView("/admin",true);
    }
}
