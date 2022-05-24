package com.example.DiffingAPI.service;


import com.example.DiffingAPI.model.DiffingOutput;
import com.example.DiffingAPI.service.impl.DiffingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffingServiceTest {

    @Autowired
    private DiffingService diffingService;

    @Test
    public void getValue() throws Exception{
        DiffingOutput diffingOutput = diffingService.equalsInput();
    }


    @Test
    public void addRightValue() throws Exception{
        String inValue="AAAAAA==";
        String s = diffingService.addRightInput(inValue);
        System.out.println("resultSet = " + s);
    }


    @Test
    public void addLeftValue() throws Exception{
        String inValue="AQABAQ==";
        String s = diffingService.addLeftInput(inValue);
        System.out.println("resultSet = " + s);
    }

}
