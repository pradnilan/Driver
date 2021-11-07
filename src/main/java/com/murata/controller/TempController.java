package com.murata.controller;

import com.murata.model.Sensor;
import com.murata.model.TempSensor;
import com.murata.service.TempServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TempController {
    
    private TempServiceImpl tempService;

    @RequestMapping("/sensors/temp")
    public List<TempSensor> getAllSensors(){
        return (List<TempSensor>) tempService.findAllSensors();
    }


    @RequestMapping(value = "sensors/temp/{id}")
    public TempSensor getByFileId(@PathVariable String id){
        TempSensor sensor=this.tempService.findSensorById(id);
        System.out.println(sensor);
        return sensor;
    }

    @Autowired
    public void setTempService(TempServiceImpl tempService) {
        this.tempService = tempService;
    }
}
