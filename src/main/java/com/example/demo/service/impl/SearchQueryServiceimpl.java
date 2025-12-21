package com.example.demo.service.impl;

import com.example.demo.model.SearchQuery;
import com.example.demo.repository.SearchQueryRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceimpl implements SearchQueryService {

    @Autowired
    SearchQueryRepository repo;

    @Override
    public SearchQuery createSearchQuery(SearchQuery obj) {
        return repo.save(obj);
    }

    @Override
    public SearchQuery updateSearchQuery(Long id, SearchQuery obj) {

        SearchQuery ex = repo.findById(id).orElse(null);

        if(ex != null) {
            ex.setName(obj.getName());
            ex.setQueryText(obj.getQueryText());
            ex.setDescription(obj.getDescription());
            ex.setActive(obj.getActive());
            return repo.save(ex);
        }

        return null;
    }

    @Override
    public SearchQuery getSearchQueryById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<SearchQuery> getAllSearchQuery() {
        return repo.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSearchQuery(Long id) {

        SearchQuery ex = repo.findById(id).orElse(null);
        ex.setActive(false);
        repo.save(ex);

        return ResponseEntity.ok("Search Query Deactivated");
    }
}
