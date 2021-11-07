package com.murata.factory;

import com.murata.model.Sensor;
import com.murata.model.SensorRaw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Component
public class SensorListFactory {

    @Autowired
    private SensorList tempSensorList;
    @Autowired
    private SensorList vibSensorList;

        public List<? extends Sensor> createSensors(String Type,List<SensorRaw> allSensorsRaw){

        if(Type.equalsIgnoreCase("Temp")){

             return tempSensorList.createSensors(allSensorsRaw);

        } else if(Type.equalsIgnoreCase("Vib")){

            return vibSensorList.createSensors(allSensorsRaw);

        }

        return null;

    }


}
