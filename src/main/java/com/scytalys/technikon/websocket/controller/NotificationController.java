package com.scytalys.technikon.websocket.controller;


import com.scytalys.technikon.websocket.model.NotificationRequest;
import com.scytalys.technikon.websocket.model.NotificationResponse;
import com.scytalys.technikon.websocket.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class NotificationController {


    private final NotificationService notificationService;

    @MessageMapping("/notification")
    @SendTo("/topic/notifications")
    public NotificationRequest getNotification(final NotificationResponse response) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendGlobalNotifications();

        return new NotificationRequest(HtmlUtils.htmlEscape(response.getMessage()));
    }

    @MessageMapping("/private-notification")
    @SendTo("/topic/private-notifications")
    public NotificationRequest getPrivateNotification(final NotificationResponse response, final Principal principal) throws InterruptedException {
        Thread.sleep(1000);
        notificationService.sendPrivateNotifications(principal.getName());

        return new NotificationRequest(HtmlUtils.htmlEscape("Sending private notification to user " + principal.getName() +
                ": " + response.getMessage()));
    }
}
