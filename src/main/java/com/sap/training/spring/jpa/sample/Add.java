package com.sap.training.spring.jpa.sample;

import org.springframework.stereotype.Component;

@Component
public class Add {

    public int add(int value1, int value2){
        return value1 + value2;
    }

}
