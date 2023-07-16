package com.instagram.clone.api;

import com.instagram.clone.entity.MemberEntity;
import com.instagram.clone.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MemberSignUpApi {
    private final MemberRepository memberRepository;
    @PostMapping("/api/signUp")
    public ResponseMemberDto signUp(@RequestBody RequestMemberDto requestMemberDto){
        log.info("requestmemberdto", requestMemberDto);
        MemberEntity memberEntity = MemberEntity.builder()
                .email(requestMemberDto.email)
                .password(requestMemberDto.pw)
                .build();

        memberRepository.save(memberEntity);

        return new ResponseMemberDto(memberEntity.getNickname());
    }

    @Data
    @NoArgsConstructor
    public static class RequestMemberDto{
        private String email;
        private String name;
        private String username;
        private String pw;

        public RequestMemberDto(String email, String name, String username, String pw) {
            this.email = email;
            this.name = name;
            this.username = username;
            this.pw = pw;
        }
    }
    @Data
    @AllArgsConstructor
    public static class ResponseMemberDto{
        private String username;

    }

}
