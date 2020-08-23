package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.FileMultipart;
import com.ereceipt.demo.domain.Prescription;
import com.ereceipt.demo.service.DoctorService;
import com.ereceipt.demo.service.FileMultipartService;
import com.ereceipt.demo.service.PatientService;
import net.bytebuddy.utility.RandomString;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@Controller
@RequestMapping("doctor")
public class DoctorController {

    private final DoctorService doctorService;
    private final PatientService patientService;
    private final FileMultipartService fileMultipartService;

    @Autowired
    public DoctorController(DoctorService doctorService,PatientService patientService,
                            FileMultipartService fileMultipartService) {
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.fileMultipartService = fileMultipartService;
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

    @GetMapping("/getPhoto/{fileId}")
    public void downlaodFile(@PathVariable UUID fileId, HttpServletResponse response) throws IOException {
        FileMultipart fileMultipart = fileMultipartService.getFile(fileId);
        response.setContentType("image/jpeg");
        byte[] bytes = fileMultipart.getData();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @PostMapping("/addPrescription")
    public RedirectView addNewDoctor(@ModelAttribute("prescription") Prescription prescription, Model model){
        doctorService.addNewPrescription(prescription);
        return new RedirectView("/doctor",true);
    }
}
