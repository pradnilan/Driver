package com.murata.factory;

import com.murata.model.Reading;
import com.murata.model.Sensor;
import com.murata.model.SensorRaw;
import com.murata.model.TempSensor;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
@PropertySource(value="file:C:\\Programming\\Data\\config.properties")
@Setter@Getter
public class TempSensorList implements SensorList {


    @Value("${sensor1.idrange}")
    private int[] idRange;
    @Value("${sensor1.staterange}")
    private int[] stateRange;
    @Value("${sensor1.voltrange}")
    private int[] voltRange;
    @Value("${sensor1.temprange}")
    private int[] tempRange;
    @Value("${sensor1.rhrange}")
    private int[] rhRange;
    @Value("${sensor1.format}")
    private int[] valueFormat;

    public TempSensorList() {
    }

    @Override
    public List<? extends Sensor> createSensors(List<SensorRaw> allSensorsRaw) {
        List<Sensor> sensorList = new ArrayList<Sensor>();

       List<String> allLinesList= allSensorsRaw.stream().map(s->s.getLine()).collect(Collectors.toList());

        allLinesList.forEach((v)->{



            TempSensor sensor=new TempSensor();
            String str;

            //Set current TS
            sensor.setTs(LocalDateTime.now());


            //set sensorId
            sensor.setSensorId(StringUtils.substring(v,idRange[0],idRange[1]));

            //set stateCode
            sensor.setStateCode(StringUtils.substring(v,stateRange[0],stateRange[1]));


            List<Object> arrayList;
            //voltage value,scale &  unit
            str=StringUtils.substring(v,voltRange[0],voltRange[1]);
            arrayList= ReadingUtility.readValue(str,valueFormat);
            sensor.setVolt(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            //temperature value,scale & unit
            str=StringUtils.substring(v,tempRange[0],tempRange[1]);
            arrayList=ReadingUtility.readValue(str,valueFormat);
            sensor.setTemp(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            //humidity value,scale & unit
            str=StringUtils.substring(v,rhRange[0],rhRange[1]);
            arrayList=ReadingUtility.readValue(str,valueFormat);
            sensor.setRh(new Reading((Float)arrayList.get(0),(Float)arrayList.get(1),
                    (String)arrayList.get(2)));

            sensorList.add(sensor);

        });

        return sensorList;

    }


}

