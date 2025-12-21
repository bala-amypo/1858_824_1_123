package com.example.demo.controller;

import com.example.demo.model.SearchQueryRecord;
import com.example.demo.service.SearchQueryService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/searchquery")
public class SearchQueryController {

    @Autowired
    SearchQueryService service;

    @PostMapping("/create")
    public SearchQuery create(@RequestBody SearchQuery obj){
        return service.createSearchQuery(obj);
    }

    @PutMapping("/update/{id}")
    public SearchQuery update(@PathVariable Long id, @RequestBody SearchQuery obj) {
        return service.updateSearchQuery(id, obj);
    }

    @GetMapping("/get/{id}")
    public SearchQuery getById(@PathVariable Long id){
        return service.getSearchQueryById(id);
    }

    @GetMapping("/all")
    public List<SearchQuery> getAll(){
        return service.getAllSearchQuery();
    }

    @PutMapping("/deactivate/{id}")
    public ResponseEntity<String> deactivate(@PathVariable Long id){
        return service.deactivateSearchQuery(id);
    }

}
