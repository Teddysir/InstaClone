package com.instagram.clone.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private String memberName;
    private String content;
}
