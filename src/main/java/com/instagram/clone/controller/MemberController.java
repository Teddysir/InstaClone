package com.instagram.clone.controller;

import com.instagram.clone.Service.MemberService;
import com.instagram.clone.dto.MemberLoginRequestDto;
import com.instagram.clone.dto.MemberRegisterRequestDto;
import com.instagram.clone.dto.TokenInfo;
import com.instagram.clone.entity.MemberEntity;
import com.instagram.clone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        TokenInfo tokenInfo = memberService.login(email,password);
        return tokenInfo;
    }

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestBody MemberRegisterRequestDto dto) {
//        MemberEntity member = MemberEntity.builder()
//                .nickname(dto.getNickname())
//                .email(dto.getEmail())
//                .password(dto.getPassword())
//                .build();
//
//        memberRepository.save(member);
//
//        return ResponseEntity.ok("회원가입 되었습니다.");
//    }

        @PostMapping("/register")
        public ResponseEntity<String> register(@RequestBody MemberEntity member){
            String nickname = member.getNickname();
            String email = member.getEmail();
            String password = member.getPassword();
            member.setRoles("USER");

            memberRepository.save(member);

            return ResponseEntity.ok("회원가입 되었습니다.");
        }
}
