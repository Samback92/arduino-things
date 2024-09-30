package com.arduino_things.arduino_things.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.arduino_things.arduino_things.model.SensorData;


public interface SensorDataRepository extends MongoRepository<SensorData, String> {

}
