package com.arduino_things.arduino_things.service;

import com.arduino_things.arduino_things.model.SensorData;
import com.arduino_things.arduino_things.repository.SensorDataRepository;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {
    
	@Autowired
    private SensorDataRepository sensorDataRepository;

	public SensorData saveData (SensorData sensorData) {
		sensorData.setTimestamp(LocalDateTime.now());
		return sensorDataRepository.insert(sensorData);

	}

	public List<SensorData> getAllData () {
		return sensorDataRepository.findAll();
	}

	public void deleteData(String id) {
        sensorDataRepository.deleteById(id);
    }
}