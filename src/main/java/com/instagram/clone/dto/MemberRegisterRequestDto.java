package com.instagram.clone.dto;

import com.instagram.clone.entity.MemberEntity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@NoArgsConstructor
public class MemberRegisterRequestDto {
    private String nickname;
    private String email;
    private String password;
    private List<String> Role = new ArrayList<>();

    public MemberRegisterRequestDto(MemberEntity member){
        this.nickname = member.getNickname();
        this.email = member.getEmail();
        this.password = member.getPassword();
        this.Role = member.getRoles();
    }

}
