package com.instagram.clone.socket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChatMessageDto {

    private String roomId;
    private String user;
    private String message;
}
