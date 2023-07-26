package com.instagram.clone.repository.search;

import com.instagram.clone.entity.member.MemberEntity;
import com.instagram.clone.entity.hashtag.HashtagEntity;
import com.instagram.clone.entity.search.SearchHashtagEntity;
import com.instagram.clone.entity.search.SearchMemberEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchHashtagRepository extends JpaRepository<HashtagEntity, Long> {
    @Query("SELECT DISTINCT h FROM HashtagEntity h INNER JOIN HashtagPostEntity p ON h.id = p.hashtag.id  WHERE h.name LIKE :text")
    List<SearchHashtagEntity> findAllByTextLike(@Param("text") String text, Pageable pageable);
}
