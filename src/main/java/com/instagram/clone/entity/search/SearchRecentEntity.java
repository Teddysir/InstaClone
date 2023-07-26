package com.instagram.clone.entity.search;

import com.instagram.clone.entity.member.MemberEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "search_recent_entity")
public class SearchRecentEntity {

//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recent_id")
    private Long recentId;

    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "searched_name")
    private String searchedName;

    @Column(name = "last_searched_date")
    private LocalDateTime lastSearchedDate;

    @Builder
    public SearchRecentEntity(String searchedName) {
        this.memberId = Long.valueOf(1);
        this.searchedName = searchedName;
    }

    public void updateLastSearchedDate() {
        this.lastSearchedDate = LocalDateTime.now();
    }
}
