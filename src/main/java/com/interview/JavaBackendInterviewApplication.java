package com.interview;

import com.interview.components.Prototype;
import com.interview.components.Singleton;
import com.interview.notification.NotificationService;
import com.interview.services.DesignService;
import com.interview.theme.ThemeApplication;
import com.interview.visitor.DocumentProcessor;
import com.interview.visitor.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class JavaBackendInterviewApplication implements CommandLineRunner {

    private final DocumentProcessor processor;
    private final Map<String, Visitor> visitors;
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
    public JavaBackendInterviewApplication(DocumentProcessor processor, Map<String, Visitor> visitors) {
        this.processor = processor;
        this.visitors = visitors;
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaBackendInterviewApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("--- Spell Check ---");
        processor.process(visitors.get("spellCheckVisitor"));

        System.out.println("\n--- HTML Export ---");
        processor.process(visitors.get("htmlExportVisitor"));

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
