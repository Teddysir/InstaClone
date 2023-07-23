package com.instagram.clone.Service;

import com.instagram.clone.dto.MemberRegisterRequestDto;
import com.instagram.clone.entity.MemberEntity;
import com.instagram.clone.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        return memberRepository.findByEmail(username)
                .map(this::createUserDetails)
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));
    }


    public UserDetails createUserDetails(MemberEntity member) {
        return User.builder()
                .username(member.getUsername())
                .password(passwordEncoder.encode(member.getPassword()))
                .roles(member.getRoles().toArray(new String[0]))
//                .roles(member.getRoles())
                .build();
    }

//    public void registerMember(MemberRegisterRequestDto requestDto) {
//        String nickname = requestDto.getNickname();
//        String email = requestDto.getEmail();
//        String password = requestDto.getPassword();
//
//        // 패스워드 암호화
//        // String encodedPassword = passwordEncoder.encode(password);
//
//        // 회원 엔티티 생성 및 저장
//        MemberEntity member = MemberEntity.builder()
//                .nickname(nickname)
//                .email(email)
//                .password(password)
//                .roles("USER") // 기본 역할은 "USER"로 지정합니다.
//                .build();
//
//        memberRepository.save(member);
//
//        log.debug("여기까지만 실행해보자");
//    }
}
