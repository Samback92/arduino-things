package com.arduino_things.arduino_things;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ArduinoThingsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ArduinoThingsApplication.class, args);
	}

}
