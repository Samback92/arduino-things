package com.arduino_things.arduino_things.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.arduino_things.arduino_things.model.SensorData;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class OldDataCleanupTask {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Scheduled(cron = "0 0 0 * * ?") // Körs dagligen vid midnatt
    public void removeOldData() {
        LocalDateTime oneWeekAgo = LocalDateTime.now().minus(1, ChronoUnit.WEEKS);
        Date oneWeekAgoDate = Date.from(oneWeekAgo.atZone(ZoneId.systemDefault()).toInstant());

        mongoTemplate.remove(
            new Query(Criteria.where("timestamp").lt(oneWeekAgoDate)),
            SensorData.class
        );

        System.out.println("Old data removed successfully");
    }
}
