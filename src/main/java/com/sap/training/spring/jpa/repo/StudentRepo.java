package com.sap.training.spring.jpa.repo;

import com.sap.training.spring.jpa.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Repository
public interface StudentRepo extends CrudRepository<Student, UUID> {
}
