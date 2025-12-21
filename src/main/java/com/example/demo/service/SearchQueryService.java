package com.example.demo.service;

import java.util.List;
import com.example.demo.model.SearchQueryRecord;
import org.springframework.http.ResponseEntity;

public interface SearchQueryService {

    SearchQueryRecord createSearchQuery(SearchQueryRecord obj);
    SearchQueryRecord updateSearchQuery(Long id, SearchQueryRecord obj);
    SearchQueryRecord getSearchQueryById(Long id);
    List<SearchQueryRecord> getAllSearchQuery();
    ResponseEntity<String> deactivateSearchQuery(Long id);
}
