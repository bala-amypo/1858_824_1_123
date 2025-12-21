package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SearchQuery;
import org.springframework.http.ResponseEntity;

public interface SearchQueryService {

    SearchQuery createSearchQuery(SearchQuery obj);
    SearchQuery updateSearchQuery(Long id, SearchQuery obj);
    SearchQuery getSearchQueryById(Long id);
    List<SearchQuery> getAllSearchQuery();
    ResponseEntity<String> deactivateSearchQuery(Long id);
}
