package com.murata.utility;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UnitLookUp {

    private static Map<String, String> lookUp = null;

    public UnitLookUp(){

        this.lookUp = new HashMap<>();
        lookUp.put("32","V");
        lookUp.put("2A","degC");
        lookUp.put("2C","%RH");
        lookUp.put("63","m/s");

    }


    public static String find(String str){

        return lookUp.get(str);

    }


}
