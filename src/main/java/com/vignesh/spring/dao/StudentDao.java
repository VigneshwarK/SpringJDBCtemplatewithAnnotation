package com.vignesh.spring.dao;

import com.vignesh.model.Student;

import java.util.List;

public interface StudentDao {
    public Integer insertStudent(Student student);
    public List<Student> getAllStudent();
    public Student getStudentById(Integer id);
    public Integer updateStudent(Student student);
    public Integer deleteStudent(Integer id);
}
