//package com.instagram.clone.service;
//
//import com.instagram.clone.dto.RequestPostDto;
//import com.instagram.clone.entity.PostEntity;
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.annotation.Rollback;
//import org.springframework.transaction.annotation.Transactional;
//
//@SpringBootTest
//@Transactional
//@Rollback(value = false)
//public class PostServiceTest {
//
//    @Autowired
//    PostService postService;
//
//    @Test
//    @DisplayName("게시물 등록 service 코드 테스트")
//    void 게시물등록(){
//
//        //given
//        RequestPostDto requestPostDto = new RequestPostDto("1번이미지", "안녕하세요");
//
//        //when
//        PostEntity post = postService.registerPost(requestPostDto);
//
//        //then
//        Assertions.assertThat(post.getContent()).isEqualTo("안녕하세요");
//    }
//
//}