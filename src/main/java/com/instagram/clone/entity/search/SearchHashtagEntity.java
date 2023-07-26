package com.instagram.clone.entity.search;

import com.instagram.clone.entity.member.MemberEntity;
import com.instagram.clone.entity.hashtag.HashtagEntity;
import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "searchHashtag_entity")
public class SearchHashtagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private Long id;

    @Column(name = "search_count")
    private Long count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag")
    private HashtagEntity hashtagEntity;

    protected SearchHashtagEntity() {
        this.count = 0L;
    }
    public void upCount() {
        this.count++;
    }
    public SearchHashtagEntity(HashtagEntity hashtagEntity) {
        this.hashtagEntity = hashtagEntity;
    }
}
