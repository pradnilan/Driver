package com.murata.service;

import com.murata.model.Sensor;
import com.murata.model.TempSensor;
import com.murata.repository.TempRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Setter
public class TempServiceImpl  {

    @Autowired
    private TempRepository tempRepository;

    public void saveAllSensors(List<TempSensor> list) {
        tempRepository.saveAll(list);
    }


    public List<TempSensor> findAllSensors() {
        return tempRepository.findAll();
    }


    public TempSensor findSensorById(String id) {
        return tempRepository.findTopBySensorIdOrderByTsDesc(id);
    }

    public List<TempSensor> findLatestSensors(){

        List<String> distinctSensors=tempRepository.findDistinctSensorsId();
        List<TempSensor> tempSensorList=new ArrayList<>();
        distinctSensors.forEach(s -> {
            tempSensorList.add(tempRepository.findTopBySensorIdOrderByTsDesc(s));
        });
        tempSensorList.sort(Comparator.naturalOrder());
        return tempSensorList;
    }



}
