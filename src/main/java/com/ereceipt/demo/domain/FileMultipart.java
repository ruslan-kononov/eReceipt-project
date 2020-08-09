package com.ereceipt.demo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "images")
public class FileMultipart {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "image_id", columnDefinition = "VARCHAR(255)")
    private String imageId;
    private String fileName;
    private String fileType;
    @Lob
    private byte[] data;

    public FileMultipart(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }

    public FileMultipart() {
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String id) {
        this.imageId = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

}
