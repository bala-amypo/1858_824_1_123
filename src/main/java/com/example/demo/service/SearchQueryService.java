package com.example.demo.service;

import com.example.demo.model.Query;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface QueryService {

    public Query createQuery(Query query);
    public Query updateQuery(Long id, Query query);
    public Query getQueryById(Long id);
    public List<Query> getAllQueries();
    public ResponseEntity<String> deactivateQuery(Long id);
}
