package com.xenostar.adaniDB.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


public class cse2022 {
    private Integer sr;

    private double enrollment;

    private String name;

    private String USN;

    // Getters and Setters
    public Integer getSr() {
        return sr;
    }

    public void setSr(Integer sr) {
        this.sr = sr;
    }

    public double getEnrollment() {
        return enrollment;
    }

    public void setEnrollment(double enrollment) {
        this.enrollment = enrollment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUSN() {
        return USN;
    }

    public void setUSN(String USN) {
        this.USN = USN;
    }
}
