package com.murata.service;

import com.murata.model.Sensor;
import com.murata.model.TempSensor;

import java.util.List;
import java.util.Optional;

public interface SensorService {

   // void saveAllSensors(List<? extends Sensor> list);
    List<? extends Sensor> findAllSensors();
    Sensor findSensorById(String id);
    }
