package com.scytalys.technikon.websocket.service;

import com.scytalys.technikon.websocket.model.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final SimpMessagingTemplate messagingTemplate;

    public void sendGlobalNotifications() {
        NotificationRequest notification = new NotificationRequest("Global notification");
        messagingTemplate.convertAndSend("/topic/notifications", notification);
    }

    public void sendPrivateNotifications(final String userId) {
        NotificationRequest notification = new NotificationRequest("Private notification");
        messagingTemplate.convertAndSendToUser(userId, "/topic/private-notifications", notification);
    }
}
