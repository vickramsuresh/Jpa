package com.sap.training.spring.jpa.sample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyCalc {

    @Autowired
    private Add service;
    @Autowired
    private Multiply multiply;

    @GetMapping("/add")
    public int add(int val1, int val2){
        return service.add(val1,val2);
    }

    @GetMapping("/multiply")
    public int multiply(int val1, int val2){
        return multiply.multiply(val1,val2);
    }

}
