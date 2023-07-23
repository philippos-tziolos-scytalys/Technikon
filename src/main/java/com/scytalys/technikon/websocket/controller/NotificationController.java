//package com.scytalys.technikon.websocket.controller;
//
//
//import com.scytalys.technikon.websocket.model.NotificationResponse;
//import lombok.RequiredArgsConstructor;
//
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import java.security.Principal;
//
//@Controller
//@RequiredArgsConstructor
//public class NotificationController {
//
//
//    private final SimpMessagingTemplate messagingTemplate;
//
//    public void sendGlobalNotification(){
//        NotificationResponse message = new NotificationResponse("Global Notification");
//
//        messagingTemplate.convertAndSend("", message);
//    }
//}
