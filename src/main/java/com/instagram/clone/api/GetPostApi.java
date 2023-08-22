package com.instagram.clone.api;

import com.instagram.clone.dto.CommentDto;
import com.instagram.clone.dto.ResponsePostByPostId;
import com.instagram.clone.entity.MemberEntity;
import com.instagram.clone.entity.PostEntity;
import com.instagram.clone.repository.LikeRepository;
import com.instagram.clone.repository.PostRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/post")
public class GetPostApi {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;

    @GetMapping("/all") //parameter : userId
    @ResponseBody
    public List<ResponsePostByPostId> showPostDto(){
        List<PostEntity> all = postRepository.findAll();

        List<ResponsePostByPostId> collect = all.stream().map(
                post -> ResponsePostByPostId.builder()
                        .postId(post.getId())
                        .image(post.getImage())
                        .content(post.getContent())
                        .title(post.getContent())
                        .likeCount(likeRepository.countByPostId(post.getId()))
                        .comments(post.getComment().stream().map(comment -> CommentDto.builder()
                                .memberName(comment.getMember())
                                .content(comment.getContent())
                                .build()).collect(Collectors.toList()))
                        .build()
        ).collect(Collectors.toList());

        return collect;
    }
}
