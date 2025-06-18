package com.xenostar.adaniDB.Repositories;


import com.xenostar.adaniDB.Entities.btech2024;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2024Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public btech2024Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private btech2024 mapRowTobtech2024(ResultSet rs, int rowNum) throws SQLException {
        btech2024 btech2024 = new btech2024();
        btech2024.setSR(rs.getDouble("SR"));
        btech2024.setTEMP(rs.getString("TEMP"));
        btech2024.setNAME(rs.getString("NAME"));
        btech2024.setPROGRAM(rs.getString("PROGRAM"));
        btech2024.setDIVISION(rs.getString("DIVISION"));
        btech2024.setBATCH(rs.getString("BATCH"));
        btech2024.setCONTACT(rs.getDouble("CONTACT"));
        btech2024.setEMAIL(rs.getString("EMAIL"));
        return btech2024;
    }

    @Tool(name = "get_all_2nd_year_students_from_table1",description = "gets the data of all the students who are in 2nd year,from the first out of the three tables of 2nd year students")
    public List<btech2024> findAll() {
        String sql = "SELECT * FROM btech2024";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024);
    }

    @Tool(name = "get_all_2nd_year_students_from_table1_by_name",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given name")
    public List<btech2024> findByName(String name) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(NAME) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024,"%"+name+"%");
    }


    @Tool(name = "get_all_2nd_year_students_from_table1_by_division",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given division")
    public List<btech2024> findByDIVISION(String DIVISION) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(DIVISION) like LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowTobtech2024,"%"+DIVISION+"%");
    }

    @Tool(name = "get_all_2nd_year_students_from_table1_by_program",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given program")
    public List<btech2024> findByPROGRAM(String PROGRAM) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(PROGRAM) LIKE LOWER(?)";
        return jdbcTemplate.query(sql,this::mapRowTobtech2024,"%"+PROGRAM+"%");
    }


    @Tool(name = "get_all_2nd_year_students_from_table1_by_program_and_division",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given program and division")
    public List<btech2024> findByProgramAndDivision(String PROGRAM, String DIVISION) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(PROGRAM) LIKE LOWER(?) AND LOWER(DIVISION) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024, "%" + PROGRAM + "%", "%" + DIVISION + "%");
    }


    @Tool(name = "get_all_2nd_year_students_from_table1_by_contact",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given contact number")
    public List<btech2024> findByCONTACT(Double CONTACT) {
        String sql = "SELECT * FROM btech2024 WHERE Contact = ?";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024,CONTACT);
    }

    @Tool(name = "get_all_2nd_year_students_from_table1_by_email",description = "gets the data of the student who is in 2nd year,from the first out of the three tables of 2nd year students, by searching through the table with the given email")
    public List<btech2024> findByEMAIL(String EMAIL) {
        String sql = "SELECT * FROM btech2024 WHERE LOWER(EMAIL) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024,"%"+EMAIL+"%");
    }

}
