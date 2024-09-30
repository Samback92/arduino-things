package com.arduino_things.arduino_things.controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.arduino_things.arduino_things.model.SensorData;
import com.arduino_things.arduino_things.service.SensorDataService;

@RestController
@CrossOrigin(origins = "*")
public class SensorDataController {

    private  SensorDataService sensorDataService;

    public SensorDataController(SensorDataService sensorDataService) {
        this.sensorDataService = sensorDataService;
    }

    @PostMapping("/post-data")
    public SensorData saveData(@RequestBody SensorData sensorData) {
        System.out.println("Received data: " + sensorData);
        return sensorDataService.saveData(sensorData);
    }
    
    @GetMapping("/get-data")
    public List<SensorData> getAllData() {
        return sensorDataService.getAllData();
    }

    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable String id) {
        System.out.println("Tar bort uppgift med namn: " + id);
        sensorDataService.deleteData(id);
    }
}
