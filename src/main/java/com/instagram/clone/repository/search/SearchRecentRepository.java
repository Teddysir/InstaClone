package com.instagram.clone.repository.search;

import com.instagram.clone.entity.search.SearchRecentEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SearchRecentRepository extends JpaRepository<SearchRecentEntity, Long> {

    @Query("SELECT s FROM SearchRecentEntity s WHERE s.searchedName = :searchedName")
    Optional<SearchRecentEntity> findBySearchedName(@Param("searchedName") String searchedName);

    @Query("SELECT s FROM SearchRecentEntity s WHERE s.memberId = :memberId")
    List<SearchRecentEntity> findAllByMemberId(@Param("memberId") Long memberId, Pageable pageable);

    @Query("DELETE FROM SearchRecentEntity s WHERE s.memberId = :memberId")
    void deleteAllByMemberId(@Param("memberId") Long memberId);
}
