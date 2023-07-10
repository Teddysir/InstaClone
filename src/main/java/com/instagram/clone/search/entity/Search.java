package com.instagram.clone.search.entity;

import javax.persistence.*;

import com.instagram.clone.member.entity.Member;
import lombok.Getter;

@Getter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
@Table(name = "searches")
public class Search {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "search_id")
    private Long id;

    @Column(name = "search_count")
    private Long count;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "username")
    private Member member;

    protected Search() {
        this.count = 0L;
    }
    public void upCount() {
        this.count++;
    }
    public Search(Member member) {
        this.member = member;
    }
}