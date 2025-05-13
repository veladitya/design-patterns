package com.real.interview.notification;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NotificationService {
    private final Map<String, Notification> notifications;

    public NotificationService(Map<String, Notification> notifications) {
        this.notifications = notifications;
    }

    public void sendNotification(String notificationType, String message) {
        Notification notification = notifications.get(notificationType);
        if (notification != null) {
            notification.notify(message);
        }
    }
}
