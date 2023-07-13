package com.instagram.clone.controller;

import com.instagram.clone.dto.RequestPostDto;
import com.instagram.clone.dto.ResponsePostDto;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @PostMapping("/register")
    public ResponsePostDto registerPost(@RequestBody RequestPostDto requestPostDto){
        PostEntity post = postService.registerPost(requestPostDto);

        return new ResponsePostDto(post.getId());
    }


}
