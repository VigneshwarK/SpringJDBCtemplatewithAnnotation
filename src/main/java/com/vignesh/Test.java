package com.vignesh;

import com.vignesh.model.Student;
import com.vignesh.spring.config.AppConfig;
import com.vignesh.spring.dao.StudentDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Test {
    public  static void main(String args[]){

        AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        StudentDao studentDao = annotationConfigApplicationContext.getBean(StudentDao.class);

        //Inserting values into Database
        System.out.println("Insert new user details");
        Student student = new Student(6,"sri","vaishu",25);
        int insertStatus = studentDao.insertStudent(student);
        if (insertStatus == 0) {System.out.println("Failed to Insert data");}
        else {System.out.println("Data Insertion Successful");}

        //Deleting values from Databse
        System.out.println("Delete user details of id : 5");
        int deleteStatus = studentDao.deleteStudent(5);
        if (deleteStatus == 0) {System.out.println("Failed to Delete");}
        else {System.out.println("Row has been Deleted");}

        //Update all details in database
        System.out.println("Update user details with id : 4");
        Student updateStudent = studentDao.getStudentById(4);
        updateStudent.setFirst_name("Navaneetha");
        updateStudent.setLast_name("Kannan");
        int updateStatus = studentDao.updateStudent(updateStudent);
        if (updateStatus == 0) {System.out.println("Failed to Update");}
        else {System.out.println("Update Successful");}

        //Get user details with ID
        System.out.println("Get user details with id : 1");
        Student studentDetail = studentDao.getStudentById(1);
        System.out.println(studentDetail);

        //Get all user details from database
        System.out.println("Get all user details");
        for (Student getAllStudent : studentDao.getAllStudent()){
            System.out.println(getAllStudent);
        }

        annotationConfigApplicationContext.close();
    }
}
