package com.instagram.clone.controller;

import com.instagram.clone.Service.MemberService;
import com.instagram.clone.dto.MemberLoginRequestDto;
import com.instagram.clone.dto.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        TokenInfo tokenInfo = memberService.login(email,password);
        return tokenInfo;
    }
}
