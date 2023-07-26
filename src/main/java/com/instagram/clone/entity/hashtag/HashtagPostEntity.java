package com.instagram.clone.entity.hashtag;

import com.instagram.clone.entity.post.PostEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "hashtag_post_entity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashtagPostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_post_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hashtag_id")
    private HashtagEntity hashtag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private PostEntity post;

    public HashtagPostEntity(HashtagEntity hashtag, PostEntity post) {
        this.hashtag = hashtag;
        this.post = post;
    }
}
