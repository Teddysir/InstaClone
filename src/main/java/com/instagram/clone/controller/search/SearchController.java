package com.instagram.clone.controller.search;

import com.instagram.clone.dto.search.SearchDto;
import com.instagram.clone.dto.search.SearchHashtagDto;
import com.instagram.clone.dto.search.SearchMemberDto;
import com.instagram.clone.dto.search.SearchRecentDto;
import com.instagram.clone.service.search.SearchService;
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
    public List<SearchDto> search(@RequestParam String text){
        final List<SearchDto> searchDtos = searchService.search(text.trim());
        return searchDtos;
    }

    @PostMapping(value = "/mark")
    public ResponseEntity<String> markSearched(@RequestParam String entityName, @RequestParam String entityType) {
        searchService.markSearched(entityName, entityType);

        return ResponseEntity.ok("검색 기록 저장 완료.");
    }

    @GetMapping(value = "/recent")
    @ResponseBody
    public List<SearchRecentDto> getRecentSearch() {
        final List<SearchRecentDto> searchDtos = searchService.getRecentSearch();

//        List<String> results = searchDtos.stream().map(dto->dto.getSearchedName()).collect(Collectors.toList());
        return searchDtos;
    }

    @DeleteMapping(value = "/recent")
    public ResponseEntity<String> deleteRecentSearch(@RequestParam String entityName) {
        searchService.deleteRecentSearch(entityName);

        return ResponseEntity.ok("검색 기록 삭제 완료");
    }

    @DeleteMapping(value = "/recent/all")
    public ResponseEntity<String> deleteAllRecentSearch() {
        searchService.deleteAllRecentSearch();

        return ResponseEntity.ok("검색 기록 모두 삭제 완료");
    }
}
