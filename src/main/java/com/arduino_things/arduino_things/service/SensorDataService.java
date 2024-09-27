package com.arduino_things.arduino_things.service;

import com.arduino_things.arduino_things.model.SensorData;

import java.util.List;
import java.time.LocalDateTime;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {
    
    private final MongoOperations mongoOperations;

	public SensorDataService(MongoOperations mongoOperations) {
		this.mongoOperations = mongoOperations;
	}

	public SensorData saveData (SensorData sensorData) {
		sensorData.setTimestamp(LocalDateTime.now());
		return mongoOperations.insert(sensorData);

	}

	public List<SensorData> getAllData () {
		return mongoOperations.findAll(SensorData.class);
	}
		
}