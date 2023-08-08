package com.instagram.clone.socket.repository;

import com.instagram.clone.socket.dto.ChatRoomDto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ChatRepository extends JpaRepository<ChatRoomDto, String> {
}
