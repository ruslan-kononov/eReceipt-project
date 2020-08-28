package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.*;
import com.ereceipt.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;


@Controller
@RequestMapping("admin")
public class AdminController {

    private final DoctorService doctorService;
    private final PharmaService pharmaService;
    private final HospitalService hospitalService;
    private final PatientService patientService;
    private final FileMultipartService fileMultipartService;

    @Autowired
    public AdminController(DoctorService doctorService, PharmaService pharmaService,
                           HospitalService hospitalService, PatientService patientService,
                           FileMultipartService fileMultipartService) {
        this.doctorService = doctorService;
        this.pharmaService = pharmaService;
        this.hospitalService = hospitalService;
        this.patientService = patientService;
        this.fileMultipartService = fileMultipartService;
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
    public RedirectView addNewDoctor(@ModelAttribute("doctor") Doctor doctor, @RequestParam(name = "image-file") MultipartFile file,
                                     Model model) throws IOException {
        FileMultipart fileMultipart = fileMultipartService.storeFile(file);
        doctor.setPhotoId(fileMultipart.getImageId());
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
    public RedirectView addNewPharmacist(@RequestParam(name = "image-file") MultipartFile file,
                                         @ModelAttribute("pharma") Pharmacist pharmacist,Model model) throws IOException {

        FileMultipart fileMultipart = fileMultipartService.storeFile(file);
        pharmacist.setPhotoId(fileMultipart.getImageId());
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
