package com.instagram.clone.service;

import com.instagram.clone.dto.RequestPostDto;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    public PostEntity registerPost(RequestPostDto requestPostDto) {
        PostEntity postEntity = PostEntity.builder()

                .Image(requestPostDto.getImage())
                .content(requestPostDto.getContent())
                .build();

        postRepository.save(postEntity);
        return postEntity;
    }

}