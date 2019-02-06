package com.vignesh.spring.dao.impl;

import com.vignesh.model.Student;
import com.vignesh.model.StudentMapper;
import com.vignesh.spring.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao {
    JdbcTemplate jdbcTemplate;

    private final String SQL_FIND_PERSON = "select * from STUDENT where ID = ?";
    private final String SQL_DELETE_PERSON = "delete from STUDENT where ID = ?";
    private final String SQL_UPDATE_PERSON = "update STUDENT set FIRST_NAME = ?, LAST_NAME = ?, AGE  = ? where ID = ?";
    private final String SQL_GET_ALL = "select * from STUDENT";
    private final String SQL_INSERT_PERSON = "insert into STUDENT(ID, FIRST_NAME, LAST_NAME, AGE) values(?,?,?,?)";

    @Autowired
    public StudentDaoImpl(DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Integer insertStudent(Student student) {
        return jdbcTemplate.update(SQL_INSERT_PERSON,student.getId(), student.getFirst_name(),student.getLast_name(),
        student.getAge());
    }

    @Override
    public List<Student> getAllStudent() {
        return jdbcTemplate.query(SQL_GET_ALL, new StudentMapper());
    }

    @Override
    public Student getStudentById(Integer id) {
        return jdbcTemplate.queryForObject(SQL_FIND_PERSON, new Object[]{id},new StudentMapper());
    }

    @Override
    public Integer updateStudent(Student student) {
        return jdbcTemplate.update(SQL_UPDATE_PERSON,student.getFirst_name(),student.getLast_name(),student.getAge(),
                student.getId());
    }

    @Override
    public Integer deleteStudent(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PERSON,id);
    }
}
