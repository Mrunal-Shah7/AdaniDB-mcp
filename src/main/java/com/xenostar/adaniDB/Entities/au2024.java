package com.xenostar.adaniDB.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;


public class au2024 {
    private double Enrollment;
    private String Name;
    private Integer Year;
    private String Division;

    public double getEnrollment() {
        return Enrollment;
    }

    public void setEnrollment(double enrollment) {
        Enrollment = enrollment;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }
}
