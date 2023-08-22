package com.instagram.clone.dto.hashtag;

import com.instagram.clone.entity.hashtag.HashtagEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashtagDto {
    private Long id;
    private String name;
    private Integer postCount;

    public HashtagDto(HashtagEntity hashtag) {
        this.id = hashtag.getId();
        this.name = hashtag.getName();
        this.postCount = hashtag.getCount();
    }
}
