package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.au2024;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class au2024Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public au2024Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private au2024 mapRowToau2024(ResultSet rs, int rowNum) throws SQLException {
        au2024 au2024 = new au2024();
        au2024.setEnrollment(rs.getDouble("enrollment")); // Use exact case "Enrollment"
        au2024.setName(rs.getString("name"));           // Use exact case "Name"
        au2024.setYear(rs.getInt("year"));              // Use exact case "Year"
        au2024.setDivision(rs.getString("division"));   // Use exact case "Division"
        return au2024;
    }

    @Tool(name = "get_all_students_from_master_table",description = "gets the data of all students of adani university from the table consisting of all the students of all the years")
    public List<au2024> findAll() {
        String sql = "SELECT * FROM au2024";
        return jdbcTemplate.query(sql, this::mapRowToau2024);
    }


    @Tool(name = "get_student_from_master_table_by_year",description = "gets the data of students from the table consisting of all the students of all the years by the year provided")
    public List<au2024> findByYear(Integer year){
        String sql = "SELECT * FROM au2024 WHERE year = ?";
        return jdbcTemplate.query(sql,this::mapRowToau2024,year);
    }

    @Tool(name = "get_student_from_master_table_by_enrollment",description = "gets the data of the student from the table consisting of all the students of all the years by searching through it's enrollment number")
    public List<au2024> findByEnrollment(double enrollment) {
        String sql = "SELECT * FROM au2024 WHERE enrollment = ?"; // Use quoted "Enrollment" for case sensitivity
        return jdbcTemplate.query(sql, this::mapRowToau2024, enrollment);
    }


    @Tool(name = "get_student_from_master_table_by_name",description = "gets the data of the student from the table consisting of all the students of all the years by searching through it's name")
    public List<au2024> findByName(String name) {
        String sql = "SELECT * FROM au2024 WHERE LOWER(name) LIKE LOWER(?)"; // Use quoted "Name" for case sensitivity
        return jdbcTemplate.query(sql, this::mapRowToau2024, "%" + name + "%");
    }
}
