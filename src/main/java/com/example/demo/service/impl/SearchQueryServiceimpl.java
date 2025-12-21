package com.example.demo.service.impl;

import com.example.demo.model.Query;
import com.example.demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repository.QueryRepository;

import java.util.List;
import org.springframework.http.ResponseEntity;

@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    QueryRepository obj;

    @Override
    public Query createQuery(Query query){
        return obj.save(query);
    }

    @Override
    public Query updateQuery(Long id, Query query){

        Query exi = obj.findById(id).orElse(null);

        if(exi != null){
            exi.setName(query.getName());
            exi.setQueryText(query.getQueryText());
            exi.setDescription(query.getDescription());
            exi.setActive(query.getActive());
            return obj.save(exi);
        }

        return null;
    }

    @Override
    public Query getQueryById(Long id){
        return obj.findById(id).orElse(null);
    }

    @Override
    public List<Query> getAllQueries(){
        return obj.findAll();
    }

    @Override
    public ResponseEntity<String> deactivateQuery(Long id){

        Query jk = obj.findById(id).orElse(null);

        jk.setActive(false);
        obj.save(jk);

        return ResponseEntity.ok("Query Deactivated");
    }
}
