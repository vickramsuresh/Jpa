package com.sap.training.spring.jpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@Getter
@Setter
public class Student {
    @Id
    private UUID studentId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;
}
