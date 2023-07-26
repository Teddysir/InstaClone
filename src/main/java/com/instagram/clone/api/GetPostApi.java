package com.instagram.clone.api;

import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.PostRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/post")
public class GetPostApi {

    private final PostRepository postRepository;

    @GetMapping("/all") //parameter : userId
    public List<ResponseShowPostDto> showPostDto(){
        List<PostEntity> all = postRepository.findAll();
        List<ResponseShowPostDto> collect = all.stream().map(
                postEntity -> ResponseShowPostDto
                        .builder()
                        .content(postEntity.getContent())
                        .image(postEntity.getImage())
                        .build()
        ).collect(Collectors.toList());

        return collect;
    }

    @Data
    @Builder
    public static class ResponseShowPostDto{
        private byte[] image;
        private String content;
    }
}
