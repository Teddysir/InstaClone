package com.instagram.clone.controller;

import com.instagram.clone.service.MemberService;
import com.instagram.clone.dto.MemberLoginRequestDto;
import com.instagram.clone.dto.TokenInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/api/login")
    public TokenInfo login(@RequestBody MemberLoginRequestDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        TokenInfo tokenInfo = memberService.login(email,password);
        return tokenInfo;
    }
}
