package com.instagram.clone.service;


import com.instagram.clone.entity.LikeEntity;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.LikeRepository;
import com.instagram.clone.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;

    public LikeEntity registerLike(Long id) {

        Optional<PostEntity> postEntity = postRepository.findById(id);

        LikeEntity likeEntity = LikeEntity.builder()
                .post(postEntity.get())
                .build();

        likeRepository.save(likeEntity);

        return likeEntity;
    }

    public Long countLike(Long postId) {

        return likeRepository.countByPostId(postId);
    }

    public void registerUnLike(Long likeId) {
        LikeEntity likeEntity = likeRepository.findById(likeId).orElse(null);

        if (likeEntity != null) {
            likeRepository.delete(likeEntity);
        }
    }



}

