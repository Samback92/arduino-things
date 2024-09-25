package com.arduino_things.arduino_things.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.arduino_things.arduino_things.model.SensorData;
import com.arduino_things.arduino_things.repository.SensorDataRepository;

@RestController
@RequestMapping("/data")
public class SensorDataController {

    @Autowired
    private final SensorDataRepository sensorDataRepository;

    public SensorDataController(SensorDataRepository sensorDataRepository) {
        this.sensorDataRepository = sensorDataRepository;
    }

    @PostMapping
    public String saveData(@RequestBody SensorData sensorData) {
        sensorData.setTimestamp(new Date());
        sensorDataRepository.save(sensorData);
        System.out.println("Received data: " + sensorData);
        return "Data saved successfully";
    }

    @GetMapping("/{id}")
    public SensorData getDataById(@PathVariable String id) {
        return sensorDataRepository.findById(id).orElse(null);
    }
    
    @GetMapping
    public Iterable<SensorData> getAllData() {
        return sensorDataRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public void deleteData(@PathVariable String id) {
        sensorDataRepository.deleteById(id);
    }

}
