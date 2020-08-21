package com.ereceipt.demo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@PrimaryKeyJoinColumn(name = "user_id")
@Table(name = "admins")
public class Admin extends User{
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate createdAt;

    public Admin(String username, String password, String firstName, String lastName, String email, UserRole role, String photoId, LocalDate createdAt) {
        super(username, password, firstName, lastName, email, role, photoId);
        this.createdAt = createdAt;
    }

    public Admin() {

    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
}
