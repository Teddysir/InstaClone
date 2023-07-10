package com.instagram.clone.member.repository;

import com.instagram.clone.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import java.time.LocalDateTime;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    Member findByEmail(String email);

//    default void updateMemberLastLogin(String email, LocalDateTime lastLoginTime) {
//        Member member = findByEmail(email);
//        member.setLastLoginTime(lastLoginTime); // setLAstLoginTime 빌드 구성
//        save(member);
//    }
}