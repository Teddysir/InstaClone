package com.instagram.clone.entity.post;
import com.instagram.clone.entity.BaseTimeEntity;
import com.instagram.clone.entity.member.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "post_entity")
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column
    private String content;

//    @Column
//    @OneToMany(mappedBy = "post")
//    private List<CommentEntity> comment = new ArrayList<>();

    @Column
    private String Image;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

}
