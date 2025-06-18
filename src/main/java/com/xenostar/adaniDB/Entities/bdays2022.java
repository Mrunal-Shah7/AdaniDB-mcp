package com.xenostar.adaniDB.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;


public class bdays2022 {
    private String Name;
    private Date DOB;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getDOB() {
        return DOB;
    }

    public void setDOB(Date DOB) {
        this.DOB = DOB;
    }



}
