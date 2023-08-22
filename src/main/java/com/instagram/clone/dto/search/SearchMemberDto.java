package com.instagram.clone.dto.search;

import com.instagram.clone.dto.member.MemberDto;
import com.instagram.clone.entity.member.MemberEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchMemberDto extends SearchDto {
    private MemberDto member;
    public SearchMemberDto(String dtype, MemberEntity memberEntity) {
        super(dtype);
        this.member = new MemberDto(memberEntity);
    }
}
