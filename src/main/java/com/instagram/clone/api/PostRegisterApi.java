package com.instagram.clone.api;

import com.instagram.clone.dto.RequestPostDto;
import com.instagram.clone.dto.ResponsePostDto;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/post")
public class PostRegisterApi {

    private final PostService postService;

    @PostMapping(value = "/v1/register",  consumes = "multipart/form-data")
    public ResponsePostDto registerPost(@RequestBody RequestPostDto requestPostDto){
        PostEntity post = postService.registerPost(requestPostDto);

        return new ResponsePostDto(post.getId());
    }

    @PostMapping(value = "/register", consumes = "multipart/form-data")
    public ResponsePostDto registerPost(@RequestParam("image") MultipartFile imageFile, @RequestParam("content") String content){
        RequestPostDto requestPostDto = new RequestPostDto();
        requestPostDto.setContent(content);
        requestPostDto.setImage(imageFile);

        PostEntity post = postService.registerPost(requestPostDto);

        return new ResponsePostDto(post.getId());
    }
}
