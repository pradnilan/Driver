package com.murata.factory;

import com.murata.model.Sensor;
import com.murata.model.SensorRaw;

import java.util.List;
import java.util.Map;


public interface SensorList {

    public List<? extends Sensor> createSensors(List<SensorRaw> latestSensorRaw);


}
