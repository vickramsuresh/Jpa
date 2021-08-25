package com.sap.training.spring.jpa.api;

import com.sap.training.spring.jpa.model.Student;
import com.sap.training.spring.jpa.repo.StudentRepo;
import org.junit.jupiter.api.*;
import org.mockito.internal.matchers.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StudentApiTest {

    @Autowired
    private StudentApi api;
    @Autowired
    private StudentRepo repo;

    private UUID studentId;

    @Test
    @Order(1)
    public void createRandom() throws Exception {
        Student student = api.createRandomRecord();
        Assertions.assertNotNull(student);
        Assertions.assertNotNull(student.getStudentId());
        Assertions.assertEquals("Random", student.getFirstName());
        Assertions.assertEquals(1,repo.count());
    }

    @Test
    @Order(2)
    public void createStudent() throws Exception {
        StudentPayload payload = new StudentPayload();
        payload.setFirstName("One");
        payload.setLastName("Two");

        Student student = api.createStudent(payload);

        studentId = student.getStudentId();

        Assertions.assertNotNull(student);
        Assertions.assertNotNull(student.getStudentId());
        Assertions.assertEquals(payload.getFirstName(), student.getFirstName());
        Assertions.assertEquals(payload.getLastName(), student.getLastName());
        Assertions.assertEquals(2,repo.count());
    }

    @Test
    @Order(3)
    public void createStudentWithNullObject() throws Exception {
        try {
            Student student = api.createStudent(null);
            Assertions.fail("Null Pointer exception should be thrown");
        } catch (NullPointerException e){

        }
    }

    @Test
    @Order(3)
    public void createStudentWithNullValue(){
        StudentPayload payload = new StudentPayload();
        try {
            Student student = api.createStudent(payload);
            Assertions.fail("Null Pointer exception should be thrown");
        } catch (Exception e){

        }
    }

    @Test
    @Order(4)
    public void updateStudent(){
        api.updateFirstName(studentId,"Four");
        Assertions.assertEquals("Four",repo.findById(studentId).get().getFirstName());
    }

    @Test
    @Order(5)
    public void updateStudent1() throws Exception {
        Student student = api.createRandomRecord();
        api.updateFirstName(student.getStudentId(),"Four");
        Assertions.assertEquals("Four",repo.findById(student.getStudentId()).get().getFirstName());
    }

}
