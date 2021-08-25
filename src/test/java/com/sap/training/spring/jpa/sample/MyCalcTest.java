package com.sap.training.spring.jpa.sample;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@Slf4j
public class MyCalcTest {

    @Autowired
    private MyCalc calc;

    @MockBean
    private Add mockAdd;

    @Test
    public void add(){

        Mockito.when(mockAdd.add(1,3)).thenReturn(1);
        Mockito.when(mockAdd.add(5,6)).thenReturn(11);
        Mockito.when(mockAdd.add(8,2)).thenReturn(5);
//        Mockito.when(mockAdd.add(ArgumentMatchers.anyInt(),ArgumentMatchers.anyInt())).thenReturn(100);

        int actual = calc.add(5,6);
        System.out.println("Actual is " + actual);
        Assertions.assertEquals(11,actual);

        actual = calc.add(8,2);
        log.info("Actual is {}", actual);
        Assertions.assertEquals(5,actual);

        actual = calc.add(1,3);
        log.warn("Actual is {}", actual);
        Assertions.assertEquals(1,actual);

    }

    @Test
    public void mult(){
        Assertions.assertEquals(6,calc.multiply(2,3));
    }

}
