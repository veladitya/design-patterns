package com.interview.notification;

import org.springframework.stereotype.Component;

@Component("email")
public class EmailNotifier implements Notification {
    @Override
    public void notify(String message) {
        System.out.println("Email Notification: " + message);
    }
}
