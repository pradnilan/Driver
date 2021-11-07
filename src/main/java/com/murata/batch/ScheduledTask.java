package com.murata.batch;

import com.murata.config.FolderConfig;
import com.murata.config.SQLConfig;
import com.murata.config.ServerConfig;
import com.murata.factory.SensorListFactory;
import com.murata.model.SensorRaw;
import com.murata.model.TempSensor;
import com.murata.model.VibSensor;
import com.murata.service.SensorRawServiceImpl;
import com.murata.service.TempServiceImpl;
import com.murata.service.VibServiceImpl;
import com.murata.utility.FileUtility;
import com.murata.utility.PathUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource(value={"file:C:\\Programming\\Data\\config.properties"})
public class ScheduledTask {

    @Autowired
    FolderConfig config;
    private String pathTemp;
    private String pathVib;
    private TempServiceImpl tempService;
    private VibServiceImpl vibService;
    private SensorRawServiceImpl sensorRawService;
    private SensorListFactory sensorFactory;
    @Autowired
    private ServerConfig server;
    @Autowired
    private SQLConfig sql;


    @Scheduled(fixedRateString = "#{config.getScanTime()}")
    public void task1(){

        System.out.println(server);
        System.out.println(sql);

        this.setPathTemp(config.getTempFolder());
        this.setPathVib(config.getVibFolder());

        // read temp&humidity sensor files and save them to database
        ArrayList<Path> allPathsTemp= PathUtility.allPaths(Paths.get(pathTemp));
        List<SensorRaw> tempSensorsRaw= FileUtility.latestSensorRaw(allPathsTemp);
        sensorRawService.saveAllSensors(tempSensorsRaw);

        List<TempSensor> tempSensors= (List<TempSensor>) sensorFactory.createSensors("Temp",tempSensorsRaw);
        tempService.saveAllSensors(tempSensors);



        // read vibration sensor files and save them to database
        ArrayList<Path> allPathsVib= PathUtility.allPaths(Paths.get(pathVib));
        List<SensorRaw> vibSensorsRaw= FileUtility.latestSensorRaw(allPathsVib);
        sensorRawService.saveAllSensors(vibSensorsRaw);

        List<VibSensor> vibSensors= (List<VibSensor>) sensorFactory.createSensors("Vib",vibSensorsRaw);
        vibService.saveAllSensors(vibSensors);


    }

   // getters & Setters

    @Autowired
    public void setTempService(TempServiceImpl tempService) {
        this.tempService = tempService;
    }

    public VibServiceImpl getVibService() {
        return vibService;
    }

    @Autowired
    public void setVibService(VibServiceImpl vibService) {
        this.vibService = vibService;
    }

    public SensorListFactory getSensorFactory() {
        return sensorFactory;
    }

    @Autowired
    public void setSensorFactory(SensorListFactory sensorFactory) {
        this.sensorFactory = sensorFactory;
    }

    public SensorRawServiceImpl getSensorRawService() {
        return sensorRawService;
    }

    @Autowired
    public void setSensorRawService(SensorRawServiceImpl sensorRawService) {
        this.sensorRawService = sensorRawService;
    }

    public void setConfig(FolderConfig config) {
        this.config = config;
    }

    public void setPathTemp(String pathTemp) {
        this.pathTemp = pathTemp;
    }

    public void setPathVib(String pathVib) {
        this.pathVib = pathVib;
    }
}
