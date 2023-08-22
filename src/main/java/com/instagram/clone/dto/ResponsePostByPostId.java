package com.instagram.clone.dto;

import com.instagram.clone.entity.CommentEntity;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Lob;
import java.util.List;

@Data
@Builder
public class ResponsePostByPostId {
    private String postId;

    @Lob
    private String content;
    private String title;
    private Long likeCount;
    private List<CommentDto> comments;
}
