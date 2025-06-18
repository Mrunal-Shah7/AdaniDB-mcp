package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.btech2024_3;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2024_3Repository {

    private final JdbcTemplate jdbcTemplate;

    public btech2024_3Repository(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private btech2024_3 mapRowTobtech2024_3(ResultSet rs,int rowNum)throws SQLException{
        btech2024_3 btech2024_3 = new btech2024_3();
        btech2024_3.setEnrollment(rs.getDouble("enrollment"));
        btech2024_3.setName(rs.getString("name"));
        btech2024_3.setDivision(rs.getString("division"));
        return btech2024_3;
    }



    @Tool(name = "get_all_2nd_year_students_from_table3",description = "gets the data of all the students who are in 2nd year,from the third out of the three tables of 2nd year students")
    public List<btech2024_3> findAll() {
        String sql = "SELECT * FROM btech2024_3";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024_3);
    }



    @Tool(name = "get_all_2nd_year_students_from_table3_by_name",description = "gets the data of the student who is in 2nd year,from the third out of the three tables of 2nd year students, by searching through the table with the given name")
    public List<btech2024_3> findByName(String name) {
        String sql = "SELECT * FROM btech2024_3 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024_3, "%" + name + "%");
    }


    @Tool(name = "get_all_2nd_year_students_from_table3_by_enrollment",description = "gets the data of the student who is in 2nd year,from the third out of the three tables of 2nd year students, by searching through the table with the given enrollment number")
    public List<btech2024_3> findByEnrollment(double enrollment){
        String sql = "SELECT * FROM btech2024_3 WHERE enrollment = ?";
        return jdbcTemplate.query(sql,this::mapRowTobtech2024_3,enrollment);
    }


}


