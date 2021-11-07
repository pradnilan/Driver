package com.murata.factory;

import com.murata.model.*;
import com.murata.utility.ReadingUtility;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@Getter@Setter
@PropertySource(value="file:C:\\Programming\\Data\\config.properties")
public class VibSensorList implements SensorList {

    @Value("${sensor2.idrange}")
    private int[] idRange;
    @Value("${sensor2.staterange}")
    private int[] stateRange;
    @Value("${sensor2.voltrange}")
    private int[] voltRange;
    @Value("${sensor2.temprange}")
    private int[] tempRange;
    @Value("${sensor2.accrmsrange}")
    private int[] accRms;
    @Value("${sensor2.format}")
    private int[] valueFormat;


    @Override
    public List<? extends Sensor> createSensors(List<SensorRaw> allSensorsRaw) {
        List<Sensor> sensorList= new ArrayList<>();
        List<String> allLinesList= allSensorsRaw.stream().map(s->s.getLine()).collect(Collectors.toList());

        allLinesList.forEach((v)->{

            VibSensor sensor=new VibSensor();
            String str;

            //Set current TS
            sensor.setTs(LocalDateTime.now());


            //set sensorId
            sensor.setSensorId(StringUtils.substring(v,idRange[0],idRange[1]));

            //set stateCode
            sensor.setStateCode(StringUtils.substring(v,stateRange[0],stateRange[1]));


            List<Object> arrayList;
            //voltage value,scale & unit
            str=StringUtils.substring(v,voltRange[0],voltRange[1]);
            arrayList= ReadingUtility.readValue(str,valueFormat);
            sensor.setVolt(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            //temperature value,scale & unit
            str=StringUtils.substring(v,tempRange[0],tempRange[1]);
            arrayList=ReadingUtility.readValue(str,valueFormat);
            sensor.setTemp(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            //AccRMS value,scale & unit
            str=StringUtils.substring(v,accRms[0],accRms[1]);
            arrayList=ReadingUtility.readValue(str,valueFormat);
            sensor.setAccRms(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            sensorList.add(sensor);

        });

        return sensorList;

    }

}

