package com.murata.service;

import com.murata.model.TempSensor;
import com.murata.model.VibSensor;
import com.murata.repository.VibRepository;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@Setter
public class VibServiceImpl {

    @Autowired
    private VibRepository vibRepository;

    public void saveAllSensors(List<VibSensor> list) {
        vibRepository.saveAll(list);
    }


    public List<VibSensor> findAllSensors() {
        return vibRepository.findAll();
    }


    public VibSensor findSensorById(String id) {
        return vibRepository.findTopBySensorIdOrderByTsDesc(id);
    }

    public List<VibSensor> findLatestSensors(){

        List<String> distinctSensors=vibRepository.findDistinctSensorsId();
        List<VibSensor> vibSensorList=new ArrayList<>();
        distinctSensors.forEach(s -> {
            vibSensorList.add(vibRepository.findTopBySensorIdOrderByTsDesc(s));
        });
        vibSensorList.sort(Comparator.naturalOrder());
        return vibSensorList;
    }

    //TODO create single service for both vib & temp senosrs

}
