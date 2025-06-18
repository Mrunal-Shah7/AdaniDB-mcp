package com.xenostar.adaniDB.Repositories;


import com.xenostar.adaniDB.Entities.btech2022;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2022Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public btech2022Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private btech2022 mapRowTobtech2022(ResultSet rs, int rowNum) throws SQLException {
        btech2022 btech2022 = new btech2022();
        btech2022.setName(rs.getString("name"));
        btech2022.setUsn(rs.getString("usn"));
        btech2022.setContact(rs.getDouble("contact"));
        btech2022.setEnrollment(rs.getDouble("enrollment"));
        btech2022.setDivision(rs.getString("division"));
        return btech2022;
    }

    @Tool(name = "get_all_4th_year_student",description = "gets the data of all the students that are in 4th year")
    public List<btech2022> findAll() {
        String sql = "SELECT * FROM btech2022";
        return jdbcTemplate.query(sql, this::mapRowTobtech2022);
    }

    @Tool(name = "get_all_4th_year_student_by_enrollment",description = "gets the data of the 4th year student by searching through the table with the given enrollment number")
    public List<btech2022> findByEnrollment(long enrollment) {
        String sql = "SELECT * FROM btech2022 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowTobtech2022, enrollment);
    }

    @Tool(name = "get_all_4th_year_student_by_name",description = "gets the data of the 4th year student by searching through the table with the given name")
    public List<btech2022> findByName(String name) {
        String sql = "SELECT * FROM btech2022 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2022, "%" + name + "%");
    }

    @Tool(name = "get_all_4th_year_student_by_usn",description = "gets the data of the 4th year student by searching through the table with the given university sear number or usn")
    public List<btech2022> findByUsn(String usn){
        String sql = "SELECT * FROM btech2022 WHERE LOWER(usn) LIKE LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowTobtech2022,"%" + usn + "%");
    }



}
