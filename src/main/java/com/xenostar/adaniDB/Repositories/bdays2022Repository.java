package com.xenostar.adaniDB.Repositories;


import com.xenostar.adaniDB.Entities.bdays2022;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class bdays2022Repository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public bdays2022Repository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private bdays2022 mapRowTobdays2022(ResultSet rs, int rowNum) throws SQLException {
        bdays2022 bdays2022 = new bdays2022();
        bdays2022.setName(rs.getString("name"));
        bdays2022.setDOB(rs.getDate("DOB"));
        return bdays2022;
    }

    @Tool(name = "get_all_students_from_bdays2022",description = "get the name and birthdate of all students from the table containing birthdates of all 4th year students")
    public List<bdays2022> findAll(){
        String sql = "SELECT * FROM bdays2022";
        return jdbcTemplate.query(sql,this::mapRowTobdays2022);
    }


    @Tool(name = "get_all_students_from_bdays2022_by_birthdate",description = "get the name and birthdate of the student from the table containing birthdates of all 4th year students by searching through the birthdate")
    public List<bdays2022> findByDOB(int DOB){
        String sql = "SELECT * FROM bdays2022 WHERE DOB = ?";
        return jdbcTemplate.query(sql,this::mapRowTobdays2022,DOB);
    }

    @Tool(name = "get_all_students_from_bdays2022_by_name",description = "get the name and birthdate of the student from the table containing birthdates of all 4th year students by searching through the name")
    public List<bdays2022> findByName(String name){
        String sql = "SELECT * FROM bdays2022 WHERE LOWER(name) LIKE LOWER(?)";
        return jdbcTemplate.query(sql, this::mapRowTobdays2022,"%"+name+"%");
    }

}
