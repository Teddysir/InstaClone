package com.instagram.clone.controller;

import com.instagram.clone.dto.*;
import com.instagram.clone.entity.CommentEntity;
import com.instagram.clone.entity.LikeEntity;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.service.CommentService;
import com.instagram.clone.service.LikeService;
import com.instagram.clone.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;
    private final CommentService commentService;
    private final LikeService likeService;

    @PostMapping("/register")
    public ResponsePostDto registerPost(@RequestBody RequestPostDto requestPostDto){
        PostEntity post = postService.registerPost(requestPostDto);

        return new ResponsePostDto(post.getId());
    }

    @PostMapping("/{postId}/comment")
    public ResponseCommentDto registerComment(@RequestBody RequestCommentDto requestCommentDto, @PathVariable Long postId) {

        requestCommentDto.setPostId(postId);
        CommentEntity comment = commentService.registerComment(requestCommentDto);
        return new ResponseCommentDto(comment.getId());
    }

    @PostMapping("/{postId}/like")
    public ResponseLikeDto registerLike(@PathVariable("postId") Long id) {

        LikeEntity like = likeService.registerLike(id);

        return new ResponseLikeDto(like.getId());
    }

    @DeleteMapping("/{postId}/unlike/{likeId}")
    public ResponseEntity<String> registerUnLike(@PathVariable("likeId") Long likeId) {

        likeService.registerUnLike(likeId);

        return ResponseEntity.ok("좋아요 취소 성공");
    }



    @PostMapping("/{postId}/likeNumber")
    public ResponseCountLikeDto countLike(@PathVariable("postId") Long id) {

        Long count = likeService.countLike(id);

        return new ResponseCountLikeDto(count);
    }



}