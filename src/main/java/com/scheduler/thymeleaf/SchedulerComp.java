package com.scheduler.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedulerComp {

    @Autowired
    PersonRepo personRepo;

    @Autowired
    ScheduleController scheduleController;
    @Scheduled(cron = "*/30 * * * * *")
    public void home() {
        System.out.println("Scheduler has started");
        List<Person> getAllPersons = (List<Person>) personRepo.findAll();
        if(getAllPersons.size()>0){
           scheduleController.performTaskUsingCron();
        }
    }
}
