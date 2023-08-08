package com.instagram.clone.socket.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Data
@Getter
@Setter
public class ChatRoomDto {

    private String roomId;
    private String roomName;

    public static ChatRoomDto create(String roomName){
        ChatRoomDto room = new ChatRoomDto();

        room.roomId = UUID.randomUUID().toString();
        room.roomName = roomName;
        return room;
    }
}
