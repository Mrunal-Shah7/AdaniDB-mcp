package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.ictb2022;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ictb2022Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ictb2022Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private ictb2022 mapRowToictb2022(ResultSet rs, int rowNum) throws SQLException {
        ictb2022 ictb2022 = new ictb2022();
        ictb2022.setName(rs.getString("name"));
        ictb2022.setRollNo(rs.getDouble("rollNo"));
        ictb2022.setContact(rs.getDouble("contact"));
        ictb2022.setEmailId(rs.getString("email"));
        ictb2022.setUsn(rs.getString("usn"));
        ictb2022.setEnrollment(rs.getDouble("enrollment"));
        return ictb2022;
    }

    @Tool(name = "get_all_ict_b_students_from_4th_year",description = "gets the data of all the 4th year students who are in ICT department and division B")
    public List<ictb2022> findAll() {
        String sql = "SELECT * FROM ictb2022";
        return jdbcTemplate.query(sql,this::mapRowToictb2022);
    }

    @Tool(name = "get_all_ict_b_students_from_4th_year_by_name",description = "gets the data of the 4th year student who is in ICT department and division B by searching through the table with the given name")
    public List<ictb2022> findByName(String name) {
        String sql =  "SELECT * FROM ictb2022 WHERE LOWER(name) LIKE LOWER(?)";
        return  jdbcTemplate.query(sql,this::mapRowToictb2022,"%"+name+"%");
    }


    @Tool(name = "get_all_ict_b_students_from_4th_year_by_contact",description = "gets the data of the 4th year student who is in ICT department and division B by searching through the table with the given contact number")
    public List<ictb2022> findByContact(double contact) {
        String sql = "SELECT *  FROM ictb2022 WHERE contact = ?";
        return jdbcTemplate.query(sql,this::mapRowToictb2022,contact);
    }

    @Tool(name = "get_all_ict_b_students_from_4th_year_by_usn",description = "gets the data of the 4th year student who is in ICT department and division B by searching through the table with the given usn or university sear number")
    public List<ictb2022> findByUSN(String usn) {
        String sql = "SELECT * FROM ictb2022 WHERE LOWER(usn) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowToictb2022, "%" + usn + "%");
    }

    @Tool(name = "get_all_ict_b_students_from_4th_year_by_enrollment",description = "gets the data of the 4th year student who is in ICT department and division B by searching through the table with the given enrollment number")
    public List<ictb2022> findByEnrollment(double enrollment) {
        String sql = "SELECT * FROM ictb2022 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowToictb2022, enrollment);
    }





}
