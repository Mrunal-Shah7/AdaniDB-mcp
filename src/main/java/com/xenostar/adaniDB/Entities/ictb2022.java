package com.xenostar.adaniDB.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

public class ictb2022 {
    private double rollNo;

    private double enrollment;

    private String usn;

    private String name;

    private double contact;


    private String email;

    // Getters and Setters
    public double getRollNo() {
        return rollNo;
    }

    public void setRollNo(double rollNo) {
        this.rollNo = rollNo;
    }

    public double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(double enrollment) {
        this.enrollment = enrollment;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getContact() {
        return contact;
    }

    public void setContact(double contact) {
        this.contact = contact;
    }

    public String getEmailId() {
        return email;
    }

    public void setEmailId(String emailId) {
        this.email = emailId;
    }
}
