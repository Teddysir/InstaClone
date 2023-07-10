package com.instagram.clone.search.repository;
import java.util.List;
import java.util.Optional;

import com.instagram.clone.search.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SearchRepository extends JpaRepository<Search, Long> {
    Optional<Search> findByMemberUsername(String username);

    @Query("SELECT s FROM Search s WHERE s.member.username LIKE CONCAT('%', :text, '%')")
    List<Search> findAllByTextLike(@Param("text") String text);
}