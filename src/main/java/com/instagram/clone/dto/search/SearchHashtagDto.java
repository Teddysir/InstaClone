package com.instagram.clone.dto.search;

import com.instagram.clone.dto.hashtag.HashtagDto;
import com.instagram.clone.entity.hashtag.HashtagEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchHashtagDto extends SearchDto {

    private HashtagDto hashtag;

    public SearchHashtagDto(String dtype, HashtagEntity hashtagEntity) {
        super(dtype);
        this.hashtag = new HashtagDto(hashtagEntity);
    }
}
