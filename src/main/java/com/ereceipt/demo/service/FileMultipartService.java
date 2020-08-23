package com.ereceipt.demo.service;

import com.ereceipt.demo.dao.FileMultipartRepository;
import com.ereceipt.demo.domain.FileMultipart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileMultipartService {

    private final FileMultipartRepository fileMultipartRepository;

    @Autowired
    public FileMultipartService(FileMultipartRepository fileMultipartRepository) {
        this.fileMultipartRepository = fileMultipartRepository;
    }

    public FileMultipart storeFile(MultipartFile file) throws IOException {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        FileMultipart multipart = null;

        if (!fileName.contains("..")) {
            multipart = new FileMultipart(fileName, file.getContentType(), file.getBytes());
        }

        return fileMultipartRepository.save(multipart);
    }

    public FileMultipart getFile(UUID fileId) throws FileNotFoundException {
        return fileMultipartRepository.findById(fileId)
                .orElseThrow(() -> new FileNotFoundException("File not found with Id =" + fileId));
    }

}
