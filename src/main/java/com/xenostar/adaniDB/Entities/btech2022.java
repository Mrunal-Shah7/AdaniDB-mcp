package com.xenostar.adaniDB.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


public class btech2022 {

    private String name;

    private String usn;

    private Double contact;

    private Double enrollment;

    private String division;

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public Double getContact() {
        return contact;
    }

    public void setContact(Double contact) {
        this.contact = contact;
    }

    public Double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Double enrollment) {
        this.enrollment = enrollment;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
