package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.cse2022;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class cse2022Repository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public cse2022Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private cse2022 mapRowTocse2022(ResultSet rs, int rowNum) throws SQLException {
        cse2022 cse2022 = new cse2022();
        cse2022.setSr(rs.getInt("sr"));
        cse2022.setName(rs.getString("name"));
        cse2022.setEnrollment(rs.getDouble("enrollment"));
        return cse2022;
    }

    @Tool(name = "get_all_cse_students_from_4th_year",description = "gets the data of all the 4th year students who are in cse department")
    public List<cse2022> findAll() {
        String sql = "select * from cse2022";
        return jdbcTemplate.query(sql,this::mapRowTocse2022);
    }

    @Tool(name = "get_all_cse_students_from_4th_year_by_name",description = "gets the data of the 4th year student who is in cse department by searching through the table with the given name")
    public List<cse2022> findByName(String name) {
        String sql = "SELECT * FROM cse2022 WHERE LOWER(name) LIKE LOWER(?)";
        return  jdbcTemplate.query(sql, this::mapRowTocse2022, "%"+name+"%");
    }

    @Tool(name = "get_all_cse_students_from_4th_year_by_enrollment",description = "gets the data of the 4th year student who is in cse department by searching through the table with the given enrollment number")
    public List<cse2022> findByEnrollment(double enrollment) {
        String sql = "SELECT * FROM cse2022 WHERE enrollment = ?";
        return jdbcTemplate.query(sql, this::mapRowTocse2022, enrollment);
    }



}
