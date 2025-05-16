package com.interview.facade;

import org.springframework.stereotype.Component;

@Component
public class NotificationServiceImpl implements NotificationService {
    @Override
    public boolean sendNotification(String trackingNumber) {
        System.out.println("NotificationServiceImpl.sendNotification()" + trackingNumber);
        return true;
    }
}
