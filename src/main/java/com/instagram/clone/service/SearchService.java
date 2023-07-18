package com.instagram.clone.service;

import com.instagram.clone.dto.search.SearchHashtagDto;
import com.instagram.clone.dto.search.SearchMemberDto;
import com.instagram.clone.entity.search.SearchHashtagEntity;
import com.instagram.clone.entity.search.SearchMemberEntity;
import com.instagram.clone.repository.SearchHashtagRepository;
import com.instagram.clone.repository.SearchMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final SearchMemberRepository searchMemberRepository;
    private final SearchHashtagRepository searchHashtagRepository;
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
}
