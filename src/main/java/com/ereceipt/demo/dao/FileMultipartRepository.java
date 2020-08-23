package com.ereceipt.demo.dao;

import com.ereceipt.demo.domain.FileMultipart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FileMultipartRepository extends JpaRepository<FileMultipart, UUID> {

}
