package com.real.interview;

import com.real.interview.components.Prototype;
import com.real.interview.components.Singleton;
import com.real.interview.notification.NotificationService;
import com.real.interview.services.DesignService;
import com.real.interview.theme.ThemeApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaBackendInterviewApplication implements CommandLineRunner {

    @Autowired
    private Prototype prototype;
    @Autowired
    private Singleton singleton;
    @Autowired
    private DesignService designService;
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private ThemeApplication themeApplication;

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendInterviewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        prototype.add("1", "1");
        prototype.add("2", "2");
        singleton.add("1", "1");
        singleton.add("2", "2");
        designService.run();

        System.out.println("Singleton: " + singleton.getCache());
        System.out.println("Prototype: " + prototype.getCache());
        designService.getCache();

        notificationService.sendNotification("email", "HI");
        notificationService.sendNotification("sms", "HI");

        themeApplication.applyTheme();
    }
}
