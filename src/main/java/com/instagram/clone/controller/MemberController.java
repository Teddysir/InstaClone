package com.instagram.clone.controller;

import com.instagram.clone.Service.CustomUserDetailsService;
import com.instagram.clone.Service.MemberService;
import com.instagram.clone.dto.MemberLoginRequestDto;
import com.instagram.clone.dto.MemberRegisterRequestDto;
import com.instagram.clone.dto.TokenInfo;
import com.instagram.clone.entity.MemberEntity;
import com.instagram.clone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberController {
    private final MemberService memberService;
    private final MemberRepository memberRepository;
    private final CustomUserDetailsService customUserDetailsService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        TokenInfo tokenInfo = memberService.login(email,password);
        return tokenInfo;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody MemberRegisterRequestDto dto) {

        MemberRegisterRequestDto member = customUserDetailsService.registerMember(dto);

        return ResponseEntity.ok("회원가입 완료");
    }




}
