package com.instagram.clone.service;

import com.instagram.clone.dto.RequestPostDto;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PostService {

    private final PostRepository postRepository;

    // 게시물 등록
    public PostEntity registerPost(RequestPostDto requestPostDto){
        PostEntity postEntity = PostEntity.builder()
//                .member() -> 멤버 정보! : 어떤 방식으로 가져올지 생각해보기
                .Image(requestPostDto.getImage())
                .content(requestPostDto.getContent())
                .build();

        postRepository.save(postEntity);
        return postEntity; // postEntity 반환
    }

    public PostEntity getPostById(Long postId) {
        Optional<PostEntity> optionalPost = postRepository.findById(postId);

        return optionalPost.orElse(null);
    }


    // 게시물 삭제


}
