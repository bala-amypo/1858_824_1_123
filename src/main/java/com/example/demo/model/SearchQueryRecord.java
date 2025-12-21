package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Query {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String queryText;
    private String description;
    private Boolean active;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getQueryText() {
        return queryText;
    }
    public void setQueryText(String queryText) {
        this.queryText = queryText;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
}

    public SearchQueryRecord(Long id,Long searcherId,String skillsRequested,Long resultsCount,Timestamp searchedAt){
        this.id = id;
        this.searcherId = searcherId;
        this.skillsRequested = skillsRequested;
        this.resultsCount = resultsCount;
        this.searchedAt = searchedAt;
    }
    public SearchQueryRecord(){
        
    }

}
