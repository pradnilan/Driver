package com.murata.controller;

import com.murata.model.TempSensor;
import com.murata.model.VibSensor;
import com.murata.service.TempServiceImpl;
import com.murata.service.VibServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VibController {

    private TempServiceImpl tempService;
    private VibServiceImpl vibService;

    @RequestMapping("/sensors/vib")
    public List<VibSensor> getAllSensors(){
        return (List<VibSensor>) vibService.findAllSensors();
    }


    @RequestMapping(value = "sensors/vib/{id}")
    public VibSensor getByFileId(@PathVariable String id){
        VibSensor sensor=this.vibService.findSensorById(id);
        return sensor;
    }


    @Autowired
    public void setTempService(TempServiceImpl tempService) {
        this.tempService = tempService;
    }

    @Autowired
    public void setVibService(VibServiceImpl vibService) {this.vibService = vibService;}
}
