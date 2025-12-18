package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.PrePersist;
import java.sql.Timestamp;

@Entity
public class SearchQueryRecord {

    @Id
    private Long id;
    private Long searcherId;
    private String skillsRequested;
    private Long resultsCount;
    private Timestamp searchedAt;
    @PrePersist
    protected void onCreate() {
        this.searchedAt = new Timestamp(System.currentTimeMillis());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSearcherId() {
        return searcherId;
    }

    public void setSearcherId(Long searcherId) {
        this.searcherId = searcherId;
    }

    public String getSkillsRequested() {
        return skillsRequested;
    }

    public void setSkillsRequested(String skillsRequested) {
        this.skillsRequested = skillsRequested;
    }

    public Long getResultsCount() {
        return resultsCount;
    }

    public void setResultsCount(Long tsCount) {
        this.resultsCount = resultsCount;
    }

    public Timestamp getSearchedAt() {
        return searchedAt;
    }

    public void setSearchedAt(Timestamp searchedAt) {
        this.searchedAt = searchedAt;
    }
    public SearchQueryRecord()

}
