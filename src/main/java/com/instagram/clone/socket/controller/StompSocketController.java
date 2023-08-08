package com.instagram.clone.socket.controller;

import com.instagram.clone.socket.dto.ChatMessageDto;
import com.instagram.clone.socket.dto.ChatRoomDto;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class StompSocketController {

    private final SimpMessagingTemplate simpMessagingTemplate; //특정 broker로 메세지 전송


    @MessageMapping(value = "/chat/enter")
    public void enter(ChatMessageDto message) {
        message.setMessage(message.getUser() + "님이 참가하셨습니다.");
        simpMessagingTemplate.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
    }
    @MessageMapping(value = "/chat/message")
    public void message(ChatMessageDto message){
        simpMessagingTemplate.convertAndSend("/sub/chat/room" + message.getRoomId(), message);
    }
}
