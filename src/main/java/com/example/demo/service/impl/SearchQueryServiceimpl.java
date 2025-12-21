package com.example.demo.service.impl;

import com.example.demo.model.SearchQuery;
import com.example.demo.service.SearchQueryService;
import com.example.demo.repository.SearchQueryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Service
public class SearchQueryServiceImpl implements SearchQueryService {

    @Autowired
    SearchQueryRepository obj;

    @Override
    public SearchQuery createSearchQuery(SearchQuery searchQuery){
        return obj.save(searchQuery);
    }

    @Override
    public SearchQuery updateSearchQuery(Long id, SearchQuery searchQuery){

        SearchQuery exi = obj.findById(id).orElse(null);

        if(exi != null){
            exi.setName(searchQuery.getName());
            exi.setQuery(searchQuery.getQuery());
            exi.setDescription(searchQuery.getDescription());
            exi.setActive(searchQuery.getActive());
            return obj.save(exi);
        }

        return null;
    }

    @Override
    public SearchQuery getSearchQueryById(Long id){
        return obj.findById(id).orElse(null);
    }

    @Override
    public List<SearchQuery> getAllSearchQueries(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateSearchQuery(Long id){

        SearchQuery jk = obj.findById(id).orElse(null);

        jk.setActive(false);
        obj.save(jk);

        return ResponseEntity.ok("Search Query Deactivated");
    }
}
