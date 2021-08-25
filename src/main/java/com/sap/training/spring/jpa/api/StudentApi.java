package com.sap.training.spring.jpa.api;

import com.sap.training.spring.jpa.model.Student;
import com.sap.training.spring.jpa.service.StudentService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class StudentApi {

    @Autowired
    private StudentService service;

    @PostMapping("/random")
    public Student createRandomRecord() throws Exception {
        return service.createStudent();
    }

    @PostMapping("/student")
    public Student createStudent( @NonNull @RequestBody StudentPayload payload ) throws Exception {
        return service.createStudent(payload.getFirstName(), payload.getLastName());
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return service.getAll();
    }

    @PatchMapping("/student/{studentId}")
    public Student updateFirstName(@PathVariable UUID studentId, @RequestBody String firstName){
        return service.updateStudentFirstName(studentId,firstName);
    }

    @DeleteMapping("/student/{studentId}")
    public Boolean deleteStudent( @PathVariable UUID studentId){
        return service.deleteStudent(studentId);
    }

}
