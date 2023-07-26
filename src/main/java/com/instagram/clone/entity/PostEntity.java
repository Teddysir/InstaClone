package com.instagram.clone.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column
    private String content;

    @Column
    @OneToMany(mappedBy = "post")
    private List<CommentEntity> comment = new ArrayList<>();

    @Column
    @OneToMany(mappedBy = "post")
    private List<LikeEntity> like = new ArrayList<>();

    @Column
    private String Image;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

}