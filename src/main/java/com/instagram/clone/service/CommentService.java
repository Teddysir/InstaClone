package com.instagram.clone.service;

import com.instagram.clone.dto.RequestCommentDto;
import com.instagram.clone.entity.CommentEntity;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.CommentRepository;
import com.instagram.clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    // 게시물 댓글 등록
    public CommentEntity registerComment(RequestCommentDto requestCommentDto) {

        Optional<PostEntity> postEntityOptional = postRepository.findById(requestCommentDto.getPostId());

        CommentEntity commentEntity = CommentEntity.builder()
                .content(requestCommentDto.getContent())
                .post(postEntityOptional.get())
                .build();

        commentRepository.save(commentEntity);
        return commentEntity;
    }
}
