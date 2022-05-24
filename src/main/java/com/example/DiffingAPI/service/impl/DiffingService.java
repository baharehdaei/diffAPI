package com.example.DiffingAPI.service.impl;

import com.example.DiffingAPI.model.DiffingOutput;
import java.io.IOException;



public interface DiffingService {

    public DiffingOutput equalsInput() throws  IOException;


    public String addRightInput(String inValue) throws IOException;


    public String addLeftInput(String inValue) throws IOException;


}
