package com.instagram.clone.dto.hashtag;

import com.instagram.clone.entity.hashtag.HashtagEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashtagDto {
    private String name;
    private Integer postCount;

    public HashtagDto(HashtagEntity hashtag) {
        this.name = hashtag.getName();
        this.postCount = hashtag.getCount();
    }
}
