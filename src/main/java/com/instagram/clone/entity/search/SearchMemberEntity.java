package com.instagram.clone.entity.search;

import javax.persistence.*;

import com.instagram.clone.entity.member.MemberEntity;
import lombok.Getter;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "searchMember_entity")
public class SearchMemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private Long id;

    @Column(name = "search_count")
    private Long count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nickname")
    private MemberEntity memberEntity;

    protected SearchMemberEntity() {
        this.count = 0L;
    }
    public void upCount() {
        this.count++;
    }
    public SearchMemberEntity(MemberEntity memberEntity) {
        this.memberEntity = memberEntity;
    }
}