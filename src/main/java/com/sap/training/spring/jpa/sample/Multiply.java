package com.sap.training.spring.jpa.sample;

import org.springframework.stereotype.Component;

@Component
public class Multiply {

    public int multiply(int value1, int value2){
        return value1 * value2;
    }
}
