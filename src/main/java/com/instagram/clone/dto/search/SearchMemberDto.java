package com.instagram.clone.dto.search;

import com.instagram.clone.dto.MemberDto;
import com.instagram.clone.entity.member.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SearchMemberDto extends SearchDto{
    private MemberDto member;
    public SearchMemberDto(MemberEntity memberEntity) {
        this.member = new MemberDto(memberEntity);
    }
}
