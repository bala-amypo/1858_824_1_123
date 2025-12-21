package com.example.demo.service.impl;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.repository.SearchQueryRecordRepository;
import com.example.demo.service.SearchQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchQueryServiceimpl implements SearchQueryService {

    @Autowired
    SearchQueryRecordRepository repo;

    @Override
    public SearchQueryRecord createSearchQuery(SearchQueryRecord obj) {
        return repo.save(obj);
    }

    @Override
    public SearchQueryRecord updateSearchQuery(Long id, SearchQueryRecord obj) {

        SearchQueryRecord ex = repo.findById(id).orElse(null);

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
    public SearchQueryRecord getSearchQueryById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<SearchQueryRecord> getAllSearchQuery() {
        return repo.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSearchQuery(Long id) {

        SearchQueryRecord ex = repo.findById(id).orElse(null);
        ex.setActive(false);
        repo.save(ex);

        return ResponseEntity.ok("Search Query Deactivated");
    }
}
