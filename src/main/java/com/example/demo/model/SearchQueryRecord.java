
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
