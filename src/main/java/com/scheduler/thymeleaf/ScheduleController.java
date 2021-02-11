package com.scheduler.thymeleaf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.List;

@Controller
public class ScheduleController {

    @Autowired
    PersonRepo personRepo;

    private final JavaMailSender javaMailSender;

   /* @RequestMapping("/home")
    public ModelAndView home(Model model, Person person) {
        model.addAttribute("house", new Person());
        List<Person> getAllPersons = (List<Person>) personRepo.findAll();
        System.out.println(getAllPersons);
        model.addAttribute("yourlist", getAllPersons);
        return new ModelAndView("test");
    }*/

    public ScheduleController(JavaMailSender javaMailSender){
        this.javaMailSender = javaMailSender;
    }
 @RequestMapping("/home")
    public void home() {
     List<Person> getAllPersons = (List<Person>) personRepo.findAll();
     if(getAllPersons.size()>0){
         sendEmail();
     }
    }

    public void sendEmail() {
        System.out.println("Sending Email...");
        sendEmailList();
        System.out.println("Sent Successfully");
    }

    public void sendEmailList() {
        System.out.println("Entered to Send Email");
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom("debal.felagi@gmail.com");
        msg.setTo("hwordoffa@gmail.com", "them22dayz@gmail.com");

        msg.setSubject("Scheduler Testing");
        msg.setText("Abule Man \n THis is the sample scheduler test");
        javaMailSender.send(msg);
    }
}
