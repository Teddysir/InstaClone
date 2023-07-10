package com.instagram.clone.member.dto;

import com.instagram.clone.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDto {
    private Long id;
    private String username;
    private String email;
    private String password;

    public MemberDto(Member member){
        this.id = member.getId();
        this.username = member.getUsername();
        this.email = member.getEmail();
        this.password = member.getPassword();
    }

}