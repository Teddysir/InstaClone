package com.instagram.clone.dto;

import com.instagram.clone.entity.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String nickname;
    private String email;
    private String password;

    public MemberDto(MemberEntity memberEntity){
        this.id = memberEntity.getMemberId();
        this.nickname = memberEntity.getNickname();
        this.email = memberEntity.getEmail();
        this.password = memberEntity.getPassword();
    }
}