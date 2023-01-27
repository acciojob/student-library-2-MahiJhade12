package com.driver.services;

import com.driver.models.Student;
import com.driver.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {


    @Autowired
    CardService cardService4;

    @Autowired
    StudentRepository studentRepository4;

    public Student getDetailsByEmail(String email){
        Student student = studentRepository4.findByEmailId(email);
        return student;
    }

    public Student getDetailsById(int id){
        Student student = studentRepository4.findById(id).get();
        return student;
    }

    public void createStudent(Student student){
       studentRepository4.save(student);
    }

    public void updateStudent(Student student){
        int id=student.getId();
        Student student1=studentRepository4.findById(id).get();
        student1.setAge(student.getAge());
        student1.setCard(student.getCard());
        student1.setCountry(student1.getCountry());
        student1.setEmailId(student1.getEmailId());
        studentRepository4.save(student1);
    }

    public void deleteStudent(int id){
        //Delete student and deactivate corresponding card
        Student student=studentRepository4.findById(id).get();
        studentRepository4.delete(student);
    }
}
