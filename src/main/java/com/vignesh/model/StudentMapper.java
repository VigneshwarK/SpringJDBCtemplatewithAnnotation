package com.vignesh.model;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentMapper implements RowMapper<Student> {

    public Student mapRow(ResultSet resultSet, int i)throws SQLException {
        Student student = new Student();
        student.setId(resultSet.getInt("id"));
        student.setFirst_name(resultSet.getString("first_name"));
        student.setLast_name(resultSet.getString("last_name"));
        student.setAge(resultSet.getInt("age"));
        return student;
    }
}
