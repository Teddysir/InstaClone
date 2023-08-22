package com.instagram.clone.dto.search;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SearchRecentDto {
    private String searchedName;
    private String dtype;
    private String profilePic;

    public SearchRecentDto (String searchedName, String dtype){
        this.searchedName = searchedName;
        this.dtype = dtype;
        profilePic = null;
    }
}
