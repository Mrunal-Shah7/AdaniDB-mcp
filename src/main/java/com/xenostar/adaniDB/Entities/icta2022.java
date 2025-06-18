package com.xenostar.adaniDB.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;


public class icta2022 {
    private double rollNo;

    private double enrollment;

    private String universitySeatNumber;

    private String name;

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

    public String getUniversitySeatNumber() {
        return universitySeatNumber;
    }

    public void setUniversitySeatNumber(String universitySeatNumber) {
        this.universitySeatNumber = universitySeatNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
