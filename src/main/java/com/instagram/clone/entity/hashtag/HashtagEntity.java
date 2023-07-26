package com.instagram.clone.entity.hashtag;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "hashtag_entity")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class HashtagEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hashtag_id")
    private Long id;

    @Column(name = "hashtag_name")
    private String name;

    @Column(name = "hashtag_count")
    private Integer count;

    @Builder
    public HashtagEntity(String name) {
        this.name = name;
        this.count = 1;
    }

    public void upCount() {
        this.count++;
    }

    public void downCount() {
        this.count--;
    }
}
