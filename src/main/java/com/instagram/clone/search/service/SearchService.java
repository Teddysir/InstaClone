package com.instagram.clone.search.service;

import com.instagram.clone.member.repository.MemberRepository;
import com.instagram.clone.search.dto.SearchDto;
import com.instagram.clone.search.entity.Search;
import com.instagram.clone.search.repository.SearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchService {

    private final SearchRepository searchRepository;
    private final MemberRepository memberRepository;
    public List<SearchDto> searchMember(String text) {
        String keyword = text.trim();
        List<Search> searches;
        searches = searchRepository.findAllByTextLike(keyword);

        return searches.stream()
                .map(search -> new SearchDto(search.getMember()))
                .collect(Collectors.toList());
    }
}
