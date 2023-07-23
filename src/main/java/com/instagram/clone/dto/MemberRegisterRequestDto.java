package com.instagram.clone.dto;

import com.instagram.clone.entity.MemberEntity;
import lombok.Builder;
import lombok.Data;


@Data
public class MemberRegisterRequestDto {
    private String nickname;
    private String email;
    private String password;

    public MemberRegisterRequestDto(MemberEntity member){
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }

}
