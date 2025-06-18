package com.xenostar.adaniDB.Repositories;

import com.xenostar.adaniDB.Entities.btech2024_2;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class btech2024_2Repository {
    private final JdbcTemplate jdbcTemplate;


    public btech2024_2Repository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public btech2024_2 mapRowTobtech2024_2(ResultSet rs, int rowNum) throws SQLException {
        btech2024_2 btech2024_2 = new btech2024_2();
        btech2024_2.setNAME(rs.getString("NAME"));
        btech2024_2.setDIVISION(rs.getString("DIVISION"));
        btech2024_2.setPROGRAM(rs.getString("PROGRAM"));
        btech2024_2.setSR(rs.getInt("SR"));
        btech2024_2.setTEMP(rs.getString("TEMP"));
        return  btech2024_2;
    }


    @Tool(name = "get_all_2nd_year_students_from_table2",description = "gets the data of all the students that are in 2nd year from the second out of the three tables of 2nd year year students")
    public List<btech2024_2> findAll() {
        String sql = "SELECT * FROM btech2024_2";
        return jdbcTemplate.query(sql, this::mapRowTobtech2024_2);
    }

    @Tool(name = "get_all_2nd_year_students_from_table2_by_name",description = "gets the data of the student who is in 2nd year,from the second out of the three tables of 2nd year students, by searching through the table with the given name")
    public List<btech2024_2> findByName(String name) {
        String sql = "SELECT * FROM btech2024_2  WHERE LOWER(name) LIKE ?";
        return jdbcTemplate.query(sql,this::mapRowTobtech2024_2,"%"+name+"%");
    }

    @Tool(name = "get_all_2nd_year_students_from_table2_by_division",description = "gets the data of the student who is in 2nd year,from the second out of the three tables of 2nd year students, by searching through the table with the given division")
    public List<btech2024_2> findByDivision(String division) {
        String sql = "SELECT * FROM btech2024_2  WHERE LOWER(division) LIKE ?";
        return jdbcTemplate.query(sql,this::mapRowTobtech2024_2,"%"+division+"%");
    }


}
