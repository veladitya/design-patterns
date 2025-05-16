package com.interview.notification;

import org.springframework.stereotype.Component;

@Component("sms")
public class SMSNotifier implements Notification {
    @Override
    public void notify(String message) {
        System.out.println("SMS Notification: " + message);
    }
}
