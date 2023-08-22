package com.instagram.clone.repository;

import com.instagram.clone.entity.LikeEntity;
import com.instagram.clone.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<LikeEntity, Long> {

    Long countByPostId(Long postId);

}

