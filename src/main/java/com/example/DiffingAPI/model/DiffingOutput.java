package com.example.DiffingAPI.model;

import java.util.ArrayList;
import java.util.List;

public class DiffingOutput {

    private String responseCode;
    private String diffResultType;
    private List<DiffsListInfo> diffsList = new ArrayList<DiffsListInfo>();


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getDiffResultType() {
        return diffResultType;
    }

    public void setDiffResultType(String transNO) {
        this.diffResultType = transNO;
    }


    public List<DiffsListInfo> getDiffsList() {
        return diffsList;
    }

    public void setDiffsList(List<DiffsListInfo> diffsList) {
        this.diffsList = diffsList;
    }

    @Override
    public String toString() {
        return " diffingOutput{" +
                "responseCode='" + responseCode + '\'' +
                ", diffResultType='" + diffResultType + '\'' +
                ", diffList='" +diffsList + '\''+
                '}';
    }




}
