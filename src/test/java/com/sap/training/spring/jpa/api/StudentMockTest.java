package com.sap.training.spring.jpa.api;

import com.sap.training.spring.jpa.model.Student;
import com.sap.training.spring.jpa.repo.StudentRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.UUID;

@SpringBootTest
public class StudentMockTest {

    @MockBean
    private StudentRepo repo;

    @Autowired
    private StudentApi api;

    @Test
    public void createStudent1() throws Exception {

        Student mockResult = new Student();
        mockResult.setStudentId(UUID.randomUUID());
        mockResult.setFirstName("1");
        mockResult.setLastName("2");
        Mockito.when(repo.save(ArgumentMatchers.any())).thenReturn(mockResult);

        Student student = api.createRandomRecord();

        Assertions.assertNotNull(student);
        Assertions.assertEquals("1", student.getFirstName());
        Assertions.assertEquals("2", student.getLastName());
    }

}
