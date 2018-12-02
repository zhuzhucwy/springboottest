package com.zhg.scheduled.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class scheduledTask {
    private Logger logger = LoggerFactory.getLogger(scheduledTask.class);

    @Scheduled(fixedRate = 2000)
    public void task(){
        logger.info("time is: {}.", LocalDateTime.now());
    }
}
