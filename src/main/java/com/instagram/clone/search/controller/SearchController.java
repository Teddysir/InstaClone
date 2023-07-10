package com.instagram.clone.search.controller;

import com.instagram.clone.search.dto.SearchDto;
import com.instagram.clone.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/search")
public class SearchController {
    private final SearchService searchService;

    @GetMapping
    public ResponseEntity<String> searchMember(@RequestParam String text){
        final List<SearchDto> searchDtos = searchService.searchMember(text);

        return ResponseEntity.ok("검색 완료 : " + searchDtos);
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
