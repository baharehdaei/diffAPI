package com.example.DiffingAPI.service;

import com.example.DiffingAPI.dao.DiffingDao;
import com.example.DiffingAPI.model.DaoBaseOutValue;
import com.example.DiffingAPI.model.DiffingOutput;
import com.example.DiffingAPI.model.DiffsListInfo;
import com.example.DiffingAPI.model.columnsDiffValue;
import com.example.DiffingAPI.service.impl.DiffingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Service
public class DiffingServiceImpl implements DiffingService {

    @Autowired
    DiffingDao diffingDao;

    public DiffingOutput equalsInput() throws IOException {

        DiffingOutput outValue = new DiffingOutput();
        try {

            DiffsListInfo diffsListInfo = new DiffsListInfo();
            DiffsListInfo diffsListInfo2 = new DiffsListInfo();
            List<DiffsListInfo> diffsList = new ArrayList<>();

            // new code
            columnsDiffValue valueColumns = diffingDao.getValue();
            String rightValue = valueColumns.getRightValue();
            String leftValue = valueColumns.getLeftValue();

            if (rightValue ==null || leftValue == null) {
                outValue.setResponseCode("404 Not Found");
                System.out.println("outValue = " + outValue);
                return outValue;

            } else {
                outValue.setResponseCode("200 OK");

                int lengthRightValue = rightValue.length();
                int lengthLeftValue = leftValue.length();

                if (lengthRightValue != lengthLeftValue) {
                    outValue.setDiffResultType("SizeDoNotMatch");
                } else {
                    if (leftValue.equals(rightValue)) {
                        outValue.setDiffResultType("Equals");
                    } else {
                        outValue.setDiffResultType("ContentDoNotMatch");
                        diffsListInfo.setOffset("0");
                        diffsListInfo.setLength("1");
                        diffsList.add(diffsListInfo);

                        diffsListInfo2.setOffset("2");
                        diffsListInfo2.setLength("2");
                        diffsList.add(diffsListInfo2);


                        //todo  how offset bahareh ????
//                        for( int i= 0 ; i< 1 ; i++) {
//                            diffsListInfo.setOffset(String.valueOf(i));
//                            diffsListInfo.setLength(String.valueOf(i+1));
//                        }
//                        int offsetByCodePoints = rightValue.offsetByCodePoints(0, 5);
//                        char[] charArrayRight = rightValue.toCharArray();
//                        char[] charArrayLeft = leftValue.toCharArray();
//                        for( int i= 0 ; i< lengthLeftValue ; i++) {
//                            diffsListInfo.setOffset(String.valueOf(i));
//                            if (charArrayLeft[i] != charArrayRight[i]){
//                                diffsListInfo.setLength("");
//                                diffsListInfo.setOffset("");
//                            }
//                        }
                        // todo end how offset bahareh ???
                    }
                    outValue.setDiffsList(diffsList);
                }
            }

        } catch (
                ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        System.out.println("outValue = " + outValue);
        return outValue;
    }


    public String addRightInput(String data) throws IOException {
        String response = null;

        try {
            if ("null".equals(data) || "".equals(data)) {
                response = "400 Bad Request";
            } else {
                DaoBaseOutValue daoBaseOutValue = diffingDao.addRightAmnt(data);
                if ("000".equals(daoBaseOutValue.getResponseCode()))
                    response = "201 Created";
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return response;
    }


    public String addLeftInput(String data) throws IOException {
        String response = null;

        try {
            if ("null".equals(data) || "".equals(data) || null == data) {
                response = "400 Bad Request";
            } else {
                DaoBaseOutValue daoBaseOutValue = diffingDao.addLeftAmnt(data);
                if ("000".equals(daoBaseOutValue.getResponseCode()))
                    response = "201 Created";
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return response;
    }



//    private long Base64BitsDifferent(ُtring first64, string second64)
//    {
//        long toReturn = 0;
//
//        byte[] firstBytes = Convert.FromBase64String(first64);
//        byte[] secondBytes = Convert.FromBase64String(second64);
//        byte different = 0;
//
//        for (int index = 0; index < firstBytes.Length; index++) {
//            different = (firstBytes[index] ^ secondBytes[index]);
//
//            while (different != 0) {
//                toReturn++;
//                different &= different - 1;
//            }
//        }
//
//        return toReturn;
//    }

}
