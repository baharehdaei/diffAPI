package com.example.DiffingAPI.dao;


import com.example.DiffingAPI.model.DiffsListInfo;
import com.example.DiffingAPI.model.columnsDiffValue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class DiffingDaoTest {

    @Autowired
    private DiffingDao diffingDao;

    @Test
    public void getValue() throws Exception {
        columnsDiffValue value = diffingDao.getValue();
        System.out.println("value = " + value);
    }

//    @Test
//    public void getRightAmnt() throws Exception{
//        diffingDao.getRightAmnt();
//    }
//
//
//    @Test
//    public void getLeftAmnt() throws Exception{
//        diffingDao.getLeftAmnt();
//    }


    @Test
    public void addRightAmntTest() throws Exception{
        String value= "AAAAAA==";
        diffingDao.addRightAmnt(value);
    }


    @Test
    public void addLeftAmnt() throws Exception{
        String value = "qwe";
        diffingDao.addLeftAmnt(value);
    }



}
