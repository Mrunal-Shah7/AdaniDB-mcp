package com.xenostar.adaniDB.Repositories;


import com.xenostar.adaniDB.Entities.icta2022;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class icta2022Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public icta2022Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private icta2022 mapRowToicta2022(ResultSet rs, int rowNum) throws SQLException {
        icta2022 icta2022 = new icta2022();
        icta2022.setName(rs.getString("name"));
        icta2022.setRollNo(rs.getDouble("rollno"));
        icta2022.setEnrollment(rs.getDouble("enrollment"));
        icta2022.setUniversitySeatNumber(rs.getString("universitySeatNumber"));
        return icta2022;
    }

    @Tool(name = "get_all_ict_a_students_from_4th_year",description = "gets the data of all the 4th year students who are in ICT department and division A")
    public List<icta2022> findAll(){
        String sql = "SELECT * FROM icta2022";
        return jdbcTemplate.query(sql,this::mapRowToicta2022);
    }

    @Tool(name = "get_all_ict_a_students_from_4th_year_by_enrollment",description = "gets the data of the 4th year student who is in ICT department and division A by searching through the table with the given enrollment number")
    public List<icta2022> findByEnrollment(double enrollment){
        String sql = "SELECT * FROM icta2022 WHERE ENROLLMENT = ?";
        return jdbcTemplate.query(sql,this::mapRowToicta2022,enrollment);
    }

    @Tool(name = "get_all_ict_a_students_from_4th_year_by_usn",description = "gets the data of the 4th year student who is in ICT department and division A by searching through the table with the given usn or univerity seat number")
    public List<icta2022> findByUniversitySeatNumber(String usn){
        String sql = "SELECT * FROM icta2022 WHERE LOWER(universitySeatNumber) LIKE LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowToicta2022,"%"+usn+"%");
    }

    @Tool(name = "get_all_ict_a_students_from_4th_year_by_name",description = "gets the data of the 4th year student who is in ICT department and division A by searching through the table with the given name")
    public List<icta2022> findByName(String name){
        String sql = "SELECT * FROM icta2022 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowToicta2022,"%"+name+"%");
    }


}
