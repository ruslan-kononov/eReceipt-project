package com.ereceipt.demo.security;

import com.ereceipt.demo.dao.DoctorRepository;
import com.ereceipt.demo.dao.PharmacistRepository;
import com.ereceipt.demo.domain.Doctor;
import com.ereceipt.demo.domain.Pharmacist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    private final DoctorRepository doctorRepository;
    private final PharmacistRepository pharmacistRepository;

    @Autowired
    public MyUserDetailsService(DoctorRepository doctorRepository,
                                PharmacistRepository pharmacistRepository) {
        this.doctorRepository = doctorRepository;
        this.pharmacistRepository = pharmacistRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Doctor> doctor = doctorRepository.findDoctorByUsername(username);
        if(!doctor.isPresent()){
            Optional<Pharmacist> pharma = pharmacistRepository.findPharmacistByUsername(username);
            pharma.orElseThrow(()->new UsernameNotFoundException("There is no user with '"+username+"' username"));
            return new MyUserDetails(pharma.get().getUsername(),pharma.get().getPassword(),
                    Arrays.asList(pharma.get().getRole()));
        }
        return new MyUserDetails(doctor.get().getUsername(),doctor.get().getPassword(),
                Arrays.asList(doctor.get().getRole()));
    }
}
