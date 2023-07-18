package com.instagram.clone.repository;
import java.util.List;

import com.instagram.clone.entity.member.MemberEntity;
import com.instagram.clone.entity.search.SearchMemberEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchMemberRepository extends JpaRepository<MemberEntity, Long> {
    @Query("SELECT m FROM MemberEntity m WHERE m.nickname LIKE :text")
    List<SearchMemberEntity> findAllByTextLike(@Param("text") String text, Pageable pageable);
}