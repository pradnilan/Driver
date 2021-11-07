package com.murata.utility;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class ReadingUtility {    //find value,scale & unit of one string



    public static List<Object> readValue(String str,int[] valueFormat){

        String valueStr= StringUtils.substring(str,valueFormat[0],valueFormat[1]);
        String scaleStr=StringUtils.substring(str,valueFormat[1],valueFormat[2]);
        String unitStr=StringUtils.substring(str,valueFormat[2],valueFormat[3]);

        float scale=ScaleLookUp.find(scaleStr);
        float value= Integer.parseInt(valueStr,16)*scale;
        String unit=UnitLookUp.find(unitStr);

        List<Object> arrayList=new ArrayList();
        arrayList.add(value);
        arrayList.add(scale);
        arrayList.add(unit);

        return arrayList;
    }

}
