package com.instagram.clone.dto.search;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class SearchDto {
    private String dtype;
    private String profilePic;

    SearchDto(String dtype){
        this.dtype = dtype;
        profilePic = null;
    }
}
