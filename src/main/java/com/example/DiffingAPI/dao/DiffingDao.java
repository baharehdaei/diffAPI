package com.example.DiffingAPI.dao;

import com.example.DiffingAPI.model.DaoBaseOutValue;
import com.example.DiffingAPI.model.columnsDiffValue;

public interface DiffingDao {


    public columnsDiffValue getValue() throws ClassNotFoundException;

    public DaoBaseOutValue addRightAmnt(String inValue) throws ClassNotFoundException;

    public DaoBaseOutValue addLeftAmnt(String inValue) throws ClassNotFoundException;

}
