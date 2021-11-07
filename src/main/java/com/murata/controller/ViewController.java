package com.murata.controller;

import com.murata.config.FolderConfig;
import com.murata.config.UpdateConfig;
import com.murata.model.Sensor;
import com.murata.service.TempServiceImpl;
import com.murata.service.VibServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ViewController {

    private TempServiceImpl tempService;
    private VibServiceImpl  vibService;
    FolderConfig config;

    // pages for sensors
    @GetMapping("/sensors/{type}/latest")
    public String latestTempSensors(@PathVariable String type, Model model){

        String msg=null;
        String page=null;
        List<? extends Sensor> list=null;
        System.out.println(type);

        if(type.equals("temp")) {
            list = tempService.findLatestSensors();
            msg="Temperature/Humidity Sensor";
            page="temp-sensors";
        } else if(type.equals("vib")){
            list = vibService.findLatestSensors();
            msg="Vibration Sensor";
            page= "vib-sensors";
        }

        model.addAttribute("latestsensors",list);
        model.addAttribute("msg",msg);
        return page;

    }

    @GetMapping("/config")
    public String getSetting(Model model){
        model.addAttribute("setting",config);
        System.out.println(config);
        return "config";
    }

    @PostMapping("/config")
    public String submitForm(@ModelAttribute("setting") FolderConfig config1){
        config.setScanTime(config1.getScanTime());
        config.setTempFolder(config1.getTempFolder());
        config.setVibFolder(config1.getVibFolder());
        UpdateConfig.write(config);
        System.out.println(config);
       return "config";
    }

    @GetMapping("/index")
    public String getHome(){

        return "index";
    }

    @Autowired
    public void setTempService(TempServiceImpl tempService) {
        this.tempService = tempService;
    }

    @Autowired
    public void setVibService(VibServiceImpl vibService) {
        this.vibService = vibService;
    }

    @Autowired
    public void setConfig(FolderConfig config) {this.config = config;}
}
