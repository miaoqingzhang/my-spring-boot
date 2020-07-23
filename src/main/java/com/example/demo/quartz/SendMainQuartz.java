package com.example.demo.quartz;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Configurable
@EnableScheduling
public class SendMainQuartz {
    private static final Logger logger = LogManager.getLogger(SendMainQuartz.class);

    @Scheduled(cron = "0/10 * * * * ?")
    public void reportCuuerntByCron() {
        logger.info("使用注解定时服务成功");
    }
}
