package com.sap.training.spring.jpa.service;

import com.sap.training.spring.jpa.model.Student;
import com.sap.training.spring.jpa.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    private int counter = 1;

    @Autowired
    private StudentRepo repo;

    public Student createStudent() throws Exception {
        counter++;
        return createStudent("Random", String.valueOf(counter));
    }

    public Student createStudent(String firstName, String lastName) throws Exception {
        Student student = new Student();
        student.setStudentId(UUID.randomUUID());
        student.setFirstName(firstName);
        student.setLastName(lastName);
        try {
            return repo.save(student);
        } catch (DataIntegrityViolationException e) {
            throw new Exception("Unable to create record");
        }

    }

    public List<Student> getAll(){
        return (List<Student>) repo.findAll();
    }

    public Student updateStudentFirstName(UUID studentId, String firstName){

       Optional<Student> optionalStudent = repo.findById(studentId);
       if(optionalStudent.isPresent()){
           Student student = optionalStudent.get();
           student.setFirstName(firstName);
           repo.save(student);
           return student;
       } else {
           throw new IllegalArgumentException("Student with id " + studentId.toString() + " does not exist");
       }

    }

    public Boolean deleteStudent(UUID studentId) {
        if(repo.existsById(studentId)){
            repo.deleteById(studentId);
            return true;
        } else {
            throw new NullPointerException("Student with id " + studentId.toString() + " does not exist");
        }
    }

}
