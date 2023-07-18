package com.instagram.clone.entity.member;
import com.instagram.clone.entity.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "member_entity")
public class MemberEntity extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "nickname", nullable = false,unique = true)
    private String nickname;

    @Column(name = "email", nullable = false,unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;
}