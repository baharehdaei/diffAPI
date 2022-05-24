package com.example.DiffingAPI.model;

public class DiffsListInfo {


    private String offset;
    private String length;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String chargeDesc) {
        this.length = chargeDesc;
    }

    @Override
    public String toString() {
        return "DiffsListInfo{" +
                "offset= " + offset +
                ", length= " + length + '\'' +
                '}';
    }

    }
