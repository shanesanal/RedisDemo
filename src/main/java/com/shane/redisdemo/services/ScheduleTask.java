package com.shane.redisdemo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {
    @Autowired
    public CarService carService;

    @Scheduled(cron = "* * * * * *")
    public void execute() {
        System.out.println("Scheduled task executed");

    }
}
