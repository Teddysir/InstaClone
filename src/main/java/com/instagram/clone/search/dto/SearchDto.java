package com.instagram.clone.search.dto;

import com.instagram.clone.member.dto.MemberDto;
import com.instagram.clone.member.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchDto {
    private MemberDto member;
    public SearchDto(Member member) {
        this.member = new MemberDto(member);
    }
}
