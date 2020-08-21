package com.ereceipt.demo.domain;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "pharmacists")
public class Pharmacist extends User{

    public Pharmacist(String username, String password, String firstName, String lastName,
                      String email, UserRole role, String photoId) {
        super(username, password, firstName, lastName, email, role, photoId);
    }

    public Pharmacist() {
    }
}
