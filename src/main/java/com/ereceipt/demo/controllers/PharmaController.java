package com.ereceipt.demo.controllers;

import com.ereceipt.demo.domain.FileMultipart;
import com.ereceipt.demo.domain.Pharmacist;
import com.ereceipt.demo.domain.Prescription;
import com.ereceipt.demo.dto.PrescriptionInfo;
import com.ereceipt.demo.dto.PrescriptionNumber;
import com.ereceipt.demo.service.FileMultipartService;
import com.ereceipt.demo.service.PharmaService;
import com.google.gson.Gson;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Controller
@RequestMapping("pharma")
public class PharmaController {
    private final PharmaService pharmaService;
    private final FileMultipartService fileMultipartService;

    @Autowired
    public PharmaController(PharmaService pharmaService, FileMultipartService fileMultipartService) {
        this.pharmaService = pharmaService;
        this.fileMultipartService = fileMultipartService;
    }

    @GetMapping("")
    public void getPharmaPage(Model model){
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Pharmacist pharma = pharmaService.findPharmacistByUsernameAndPassword(userDetails.getUsername(),
                userDetails.getPassword());
        model.addAttribute("pharma",pharma);
    }

    @GetMapping("/getPhoto/{fileId}")
    public void downlaodFile(@PathVariable UUID fileId, HttpServletResponse response) throws IOException {
        FileMultipart fileMultipart = fileMultipartService.getFile(fileId);
        response.setContentType("image/jpeg");
        byte[] bytes = fileMultipart.getData();
        InputStream inputStream = new ByteArrayInputStream(bytes);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @GetMapping("/settings/{username}")
    public String getPharmaSettingsPage(@PathVariable String username, Model model){
        model.addAttribute("username",username);
        model.addAttribute("userRole","pharma");
        return "settings";
    }

    @PostMapping(path = "/checkPrescription",consumes = "application/json", produces = "application/json")
    public @ResponseBody String checkPrescription(@RequestBody PrescriptionNumber number){
        Prescription prescription = pharmaService.findPrescriptionByItsCode(number.prescriptionNumber);
        PrescriptionInfo info = new PrescriptionInfo();
        if(prescription==null){
            return new Gson().toJson("not found");
        }
        info.prescrId = prescription.getPrescrId().toString();
        info.patientName = prescription.getPatient().getFirstName()+" "+prescription.getPatient().getLastName();
        info.doctorName = prescription.getDoctor().getFirstName()+" "+prescription.getDoctor().getLastName();
        info.medicine = prescription.getMedicineName();
        info.date = prescription.getUtilDate().toString();
        info.status = prescription.getHanded().toString();
        String json = new Gson().toJson(info);
        return json;
    }

    @PostMapping(path = "/issuePrescription",consumes = "application/json")
    public @ResponseBody String issuePrescription(@RequestBody PrescriptionNumber number){
        Prescription prescription = pharmaService.findPrescriptionById(Long.parseLong(number.prescriptionNumber));
        if(!prescription.getHanded()){
            prescription.setHanded(true);
            pharmaService.savePrescription(prescription);
            return new Gson().toJson("success");
        }else{
            return new Gson().toJson("already issued");
        }
    }

    @PostMapping("/updatePhoto")
    public RedirectView updateProfileImage(@RequestParam(name = "image-file") MultipartFile file,
                                            @RequestParam(name = "username") String username) throws IOException {
        Pharmacist pharmacist = pharmaService.findPharmacistByUsername(username);
        if(pharmacist.getPhotoId()!=null){
            fileMultipartService.deleteFile(pharmacist.getPhotoId());
        }
        FileMultipart fileMultipart = fileMultipartService.storeFile(file);
        pharmacist.setPhotoId(fileMultipart.getImageId());
        pharmaService.addNewPharmacist(pharmacist);
        return new RedirectView("/pharma",true);
    }
}
