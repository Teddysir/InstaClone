package com.instagram.clone.dto;

import lombok.Data;


@Data
public class MemberRegisterRequestDto {
    private String nickname;
    private String email;
    private String password;

}
