package com.instagram.clone.service.search;

import com.instagram.clone.dto.search.SearchHashtagDto;
import com.instagram.clone.dto.search.SearchMemberDto;
import com.instagram.clone.dto.search.SearchRecentDto;
import com.instagram.clone.entity.search.SearchHashtagEntity;
import com.instagram.clone.entity.search.SearchMemberEntity;
import com.instagram.clone.entity.search.SearchRecentEntity;
import com.instagram.clone.repository.member.MemberRepository;
import com.instagram.clone.repository.search.SearchHashtagRepository;
import com.instagram.clone.repository.search.SearchMemberRepository;
import com.instagram.clone.repository.search.SearchRecentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class SearchService {

    private final MemberRepository memberRepository;
    private final SearchMemberRepository searchMemberRepository;
    private final SearchHashtagRepository searchHashtagRepository;
    private final SearchRecentRepository searchRecentRepository;

    public List<SearchMemberDto> searchMember(String text) {
        String keyword = text + "%";

        List<SearchMemberEntity> searchMemberEntities;
        Pageable pageable = PageRequest.of(0, 5);
        searchMemberEntities = searchMemberRepository.findAllByTextLike(keyword, pageable);

        return searchMemberEntities.stream()
                .map(searchMemberEntity -> new SearchMemberDto(searchMemberEntity.getMemberEntity()))
                .collect(Collectors.toList());
    }

    public List<SearchHashtagDto> searchHashtag(String text) {
        String keyword = text + "%";

        List<SearchHashtagEntity> searchHashtagEntities;
        Pageable pageable = PageRequest.of(0, 5);
        searchHashtagEntities = searchHashtagRepository.findAllByTextLike(keyword, pageable);

        return searchHashtagEntities.stream()
                .map(searchHashtagEntity -> new SearchHashtagDto(searchHashtagEntity.getHashtagEntity()))
                .collect(Collectors.toList());
    }

    public void markSearched(String entityName){
        final SearchRecentEntity searchRecent = SearchRecentEntity.builder()
                .searchedName(entityName)
                .build();
        searchRecent.updateLastSearchedDate();
        searchRecentRepository.save(searchRecent);
    }

    public List<SearchRecentDto> getRecentSearch(){
        final Long memberId = Long.valueOf(1);
        final Pageable pageable = PageRequest.of(0, 15);
        final List<SearchRecentEntity> searches = searchRecentRepository.findAllByMemberId(memberId, pageable);

        return searches.stream()
                .map(searchRecentEntity -> new SearchRecentDto(searchRecentEntity.getSearchedName()))
                .collect(Collectors.toList());
    }

    public void deleteRecentSearch(String entityName){
        searchRecentRepository.findBySearchedName(entityName)
                .ifPresent(searchRecentRepository::delete);
    }

    public void deleteAllRecentSearch(){
        searchRecentRepository.deleteAllByMemberId(Long.valueOf(1));
    }
}
