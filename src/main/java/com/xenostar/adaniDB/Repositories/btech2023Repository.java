package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.btech2023;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2023Repository {
    private final JdbcTemplate jdbcTemplate;

    public btech2023Repository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private btech2023 mapRowTobtech2023(ResultSet rs,int rowNum) throws SQLException{
        btech2023 btech2023 = new btech2023();
        btech2023.setEnrollment(rs.getDouble("enrollment"));
        btech2023.setName(rs.getString("name"));
        btech2023.setDivision(rs.getString("division"));
        return btech2023;
    }

    @Tool(name = "get_all_3rd_year_student",description = "gets the data of all the students that are in 3rd year")
    public List<btech2023> findAll() {
        String sql = "SELECT * FROM btech2023";
        return jdbcTemplate.query(sql, this::mapRowTobtech2023);
    }

    @Tool(name = "get_all_3rd_year_student_by_enrollment",description = "gets the data of the 3rd year student by searching through the table with the given enrollment number")
    public List<btech2023> findByEnrollment(double enrollment) {
        String sql = "SELECT * FROM btech2023 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowTobtech2023, enrollment);
    }

    @Tool(name = "get_all_3rd_student_by_name",description = "gets the data of the 3rd year student by searching through the table with the given name")
    public List<btech2023> findByName(String name) {
        String sql = "SELECT * FROM btech2023 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2023, "%" + name + "%");
    }


}

