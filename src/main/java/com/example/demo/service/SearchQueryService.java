package com.example.demo.service;

import com.example.demo.model.SearchQuery;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface SearchQueryService {

    public SearchQuery createSearchQuery(SearchQuery searchQuery);
    public SearchQuery updateSearchQuery(Long id, SearchQuery searchQuery);
    public SearchQuery getSearchQueryById(Long id);
    public List<SearchQuery> getAllSearchQueries();
    public ResponseEntity<String> deactivateSearchQuery(Long id);
}
