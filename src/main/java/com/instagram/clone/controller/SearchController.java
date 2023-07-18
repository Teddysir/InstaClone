package com.instagram.clone.controller;

import com.instagram.clone.dto.search.SearchDto;
import com.instagram.clone.dto.search.SearchHashtagDto;
import com.instagram.clone.dto.search.SearchMemberDto;
import com.instagram.clone.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    @ResponseBody
    public ResponseEntity<String> searchMember(@RequestParam String text){
        text = text.trim();
        List<String> results;

        if(text.charAt(0) == '#') {
            if (text.equals('#')) {
                results = Collections.emptyList();
            } else {
                final List<SearchHashtagDto> searchHashtagDtos = searchService.searchHashtag(text.substring(1));
                results = searchHashtagDtos.stream().map(dto->dto.getHashtag().getName()).collect(Collectors.toList());
            }
        } else {
            final List<SearchMemberDto> searchMemberDtos = searchService.searchMember(text);
            results = searchMemberDtos.stream().map(dto->dto.getMember().getNickname()).collect(Collectors.toList());
        }
        return ResponseEntity.ok("검색 완료 : " + results);
    }

    //    @PostMapping(value = "/mark")
    //    public ResponseEntity<String> markSearchedEntity(@RequestParam String entityName, @RequestParam String entityType) {
    //        searchService.markSearchedEntity(entityName, entityType);
    //
    //        return ResponseEntity.ok("검색 기록 저장 완료.");
    //    }
    //
    //    @GetMapping(value = "/recent")
    //    public ResponseEntity<String> getRecentSearch() {
    //        final List<SearchDto> searchDtos = searchService.getRecentSearches();
    //
    //        return ResponseEntity.ok("검색 기록 조회 완료.");
    //    }
    //
    //    @DeleteMapping(value = "/recent")
    //    public ResponseEntity<String> deleteRecentSearch(@RequestParam String entityName, @RequestParam String entityType) {
    //        searchService.deleteRecentSearch(entityName, entityType);
    //
    //        return ResponseEntity.ok("검색 기록 삭제 완료");
    //    }
    //
    //    @DeleteMapping(value = "/recent/all")
    //    public ResponseEntity<String> deleteAllRecentSearch() {
    //        searchService.deleteAllRecentSearch();
    //
    //        return ResponseEntity.ok("검색 기록 모두 삭제 완료");
    //    }
}
