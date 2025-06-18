package com.xenostar.adaniDB.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


public class btech2023 {
    private Double enrollment;

    private String name;

    private String division;

    // Getters and Setters
    public Double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(Double enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }
}
