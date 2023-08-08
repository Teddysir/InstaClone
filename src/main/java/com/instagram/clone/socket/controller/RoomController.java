package com.instagram.clone.socket.controller;

import com.instagram.clone.socket.dto.ChatRoomDto;
import com.instagram.clone.socket.repository.ChatRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class RoomController {
    private final ChatRepository chatRepository;

    @GetMapping("/rooms")
    public List<ResponseRoomDto>rooms() {
        List<ChatRoomDto> all = chatRepository.findAll();
        List<ResponseRoomDto> collect = all.stream().map(room ->
            ResponseRoomDto.builder()
                    .roomName(room.getRoomName())
                    .build()
        ).collect(Collectors.toList());
        return collect;
    }
    @PostMapping("/room")
    public String create(@RequestParam String roomName, RedirectAttributes rttf){
        log.info("Create room, name: ", roomName);
        rttf.addFlashAttribute("roomName", ChatRoomDto.create(roomName));

        return "redirect:/chat/rooms";
    }
    @Data
    @Builder
    public static class ResponseRoomDto{
        private String roomName;
    }
}
