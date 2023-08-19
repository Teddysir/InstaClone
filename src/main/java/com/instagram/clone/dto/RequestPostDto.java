package com.instagram.clone.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestPostDto {
    private byte[] image;

    private String content;

    public void setImage(MultipartFile file) {
        try {
            this.image = file.getBytes();
        } catch (IOException e) {
            // 예외 처리
        }
    }
}
