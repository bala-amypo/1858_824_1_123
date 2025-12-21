package com.example.demo.controller;

import com.example.demo.model.SearchQuery;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/searchQuery")
public class SearchQueryController {

    @Autowired
    SearchQueryService searchQueryService;

    @PostMapping("/create")
    public SearchQuery createSearchQuery(@RequestBody SearchQuery searchQuery) {
        return searchQueryService.createSearchQuery(searchQuery);
    }

    @PutMapping("/update/{id}")
    public SearchQuery updateSearchQuery(@PathVariable Long id,@RequestBody SearchQuery searchQuery) {
        return searchQueryService.updateSearchQuery(id, searchQuery);
    }

    @GetMapping("/get/{id}")
    public SearchQuery getSearchQueryById(@PathVariable Long id) {
        return searchQueryService.getSearchQueryById(id);
    }

    @GetMapping("/getAll")
    public List<SearchQuery> getAllSearchQueries() {
        return searchQueryService.getAllSearchQueries();
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivateSearchQuery(@PathVariable Long id) {
        return searchQueryService.deactivateSearchQuery(id);
    }
}
