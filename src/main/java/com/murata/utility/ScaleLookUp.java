package com.murata.utility;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ScaleLookUp {

    private static Map<String, Float> lookUp = new HashMap<>();

    public ScaleLookUp(){

        //this.lookUp = new HashMap<>();
        lookUp.put("00",1.0f);
        lookUp.put("01",10.0f);
        lookUp.put("02",100.0f);
        lookUp.put("03",1000.0f);
        lookUp.put("04",0.1f);
        lookUp.put("05",0.01f);
        lookUp.put("06",0.001f);

    }


    public static float find(String str){

      return lookUp.get(str);

    }


}
