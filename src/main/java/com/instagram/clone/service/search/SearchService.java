package com.instagram.clone.service.search;

import com.instagram.clone.dto.search.SearchDto;
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
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class SearchService {

    private final MemberRepository memberRepository;
    private final SearchMemberRepository searchMemberRepository;
    private final SearchHashtagRepository searchHashtagRepository;
    private final SearchRecentRepository searchRecentRepository;

    public List<SearchDto> search(String text) {
        List<SearchDto> searchDtos;
        String keyword = text + "%";
        Pageable pageable = PageRequest.of(0, 5);

        if(text.charAt(0) == '#') {
            if (text.equals("#")) {
                searchDtos = Collections.emptyList();
            } else {
                searchDtos = searchHashtagRepository.findAllByTextLike(keyword.substring(1), pageable).stream()
                        .map(searchHashtagEntity -> new SearchHashtagDto("HASHTAG", searchHashtagEntity.getHashtagEntity()))
                        .collect(Collectors.toList());
            }
        } else {
            searchDtos = searchMemberRepository.findAllByTextLike(keyword, pageable).stream()
                    .map(searchMemberEntity -> new SearchMemberDto("MEMBER", searchMemberEntity.getMemberEntity()))
                    .collect(Collectors.toList());
        }

        for (SearchDto search : searchDtos) {
            switch (search.getDtype()) {
                case "MEMBER":
                    search.setProfilePic("https://i.pinimg.com/564x/6a/be/29/6abe2929274d6459c815ac752fb0c057.jpg");
                    break;
                case "HASHTAG":
                    search.setProfilePic("https://images.vexels.com/media/users/3/143542/isolated/preview/af51f3dd7eae8f54b9fff8e94ef12c75-music-sharp-sign.png");
                default:
            }
        }

        return searchDtos;
    }

    public void markSearched(String entityName, String entityType){
        final SearchRecentEntity searchRecent = SearchRecentEntity.builder()
                .searchedName(entityName)
                .dtype(entityType)
                .build();
        searchRecent.updateLastSearchedDate();
        searchRecentRepository.save(searchRecent);
    }

    public List<SearchRecentDto> getRecentSearch(){
        final Long memberId = Long.valueOf(1);
        final Pageable pageable = PageRequest.of(0, 15);
        final List<SearchRecentEntity> searches = searchRecentRepository.findAllByMemberId(memberId, pageable);

        List<SearchRecentDto> searchDtos = searches.stream()
                .map(searchRecentEntity -> new SearchRecentDto(searchRecentEntity.getSearchedName(),searchRecentEntity.getDtype()))
                .collect(Collectors.toList());

        for (SearchRecentDto search : searchDtos) {
            switch (search.getDtype()) {
                case "MEMBER":
                    search.setProfilePic("https://i.pinimg.com/564x/6a/be/29/6abe2929274d6459c815ac752fb0c057.jpg");
                    break;
                case "HASHTAG":
                    search.setProfilePic("https://images.vexels.com/media/users/3/143542/isolated/preview/af51f3dd7eae8f54b9fff8e94ef12c75-music-sharp-sign.png");
                default:
            }
        }

        return searchDtos;
    }

    public void deleteRecentSearch(String entityName){
        searchRecentRepository.findBySearchedName(entityName)
                .ifPresent(searchRecentRepository::delete);
    }

    public void deleteAllRecentSearch(){
        searchRecentRepository.deleteAllByMemberId(Long.valueOf(1));
    }
}
