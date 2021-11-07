package com.murata.service;

import com.murata.model.SensorRaw;
import com.murata.model.TempSensor;
import com.murata.repository.SensorRawRepository;
import com.murata.repository.TempRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SensorRawServiceImpl {


    @Autowired
    private SensorRawRepository sensorRawRepository;

    public void saveAllSensors(List<SensorRaw> list) {sensorRawRepository.saveAll(list);}

}
