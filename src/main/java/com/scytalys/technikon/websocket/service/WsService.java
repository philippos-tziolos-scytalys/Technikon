package com.scytalys.technikon.websocket.service;

import com.scytalys.technikon.websocket.model.NotificationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WsService {

    private final SimpMessagingTemplate messagingTemplate;
    private final NotificationService notificationService;


    public void notifyFrontend(final String message) {
        NotificationRequest response = new NotificationRequest(message);
        notificationService.sendGlobalNotifications();

        messagingTemplate.convertAndSend("/topic/messages", response);
    }

    public void notifyUser(final String id, final String message) {
        NotificationRequest response = new NotificationRequest(message);

        notificationService.sendPrivateNotifications(id);
        messagingTemplate.convertAndSendToUser(id, "/topic/private-messages", response);
    }
}