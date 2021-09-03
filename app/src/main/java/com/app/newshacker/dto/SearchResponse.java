package com.app.newshacker.dto;

import java.util.List;

public class SearchResponse {


    public class Title
    {
        private String value;

        private String matchLevel;

        private boolean fullyHighlighted;

        private List<String> matchedWords;

        public void setValue(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
        public void setMatchLevel(String matchLevel){
            this.matchLevel = matchLevel;
        }
        public String getMatchLevel(){
            return this.matchLevel;
        }
        public void setFullyHighlighted(boolean fullyHighlighted){
            this.fullyHighlighted = fullyHighlighted;
        }
        public boolean getFullyHighlighted(){
            return this.fullyHighlighted;
        }
        public void setMatchedWords(List<String> matchedWords){
            this.matchedWords = matchedWords;
        }
        public List<String> getMatchedWords(){
            return this.matchedWords;
        }
    }


    public class Url
    {
        private String value;

        private String matchLevel;

        private boolean fullyHighlighted;

        private List<String> matchedWords;

        public void setValue(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
        public void setMatchLevel(String matchLevel){
            this.matchLevel = matchLevel;
        }
        public String getMatchLevel(){
            return this.matchLevel;
        }
        public void setFullyHighlighted(boolean fullyHighlighted){
            this.fullyHighlighted = fullyHighlighted;
        }
        public boolean getFullyHighlighted(){
            return this.fullyHighlighted;
        }
        public void setMatchedWords(List<String> matchedWords){
            this.matchedWords = matchedWords;
        }
        public List<String> getMatchedWords(){
            return this.matchedWords;
        }
    }

    public class Author
    {
        private String value;

        private String matchLevel;

        private List<String> matchedWords;

        public void setValue(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
        public void setMatchLevel(String matchLevel){
            this.matchLevel = matchLevel;
        }
        public String getMatchLevel(){
            return this.matchLevel;
        }
        public void setMatchedWords(List<String> matchedWords){
            this.matchedWords = matchedWords;
        }
        public List<String> getMatchedWords(){
            return this.matchedWords;
        }
    }


    public class Story_text
    {
        private String value;

        private String matchLevel;

        private List<String> matchedWords;

        public void setValue(String value){
            this.value = value;
        }
        public String getValue(){
            return this.value;
        }
        public void setMatchLevel(String matchLevel){
            this.matchLevel = matchLevel;
        }
        public String getMatchLevel(){
            return this.matchLevel;
        }
        public void setMatchedWords(List<String> matchedWords){
            this.matchedWords = matchedWords;
        }
        public List<String> getMatchedWords(){
            return this.matchedWords;
        }
    }


    public class _highlightResult
    {
        private Title title;

        private Url url;

        private Author author;

        private Story_text story_text;

        public void setTitle(Title title){
            this.title = title;
        }
        public Title getTitle(){
            return this.title;
        }
        public void setUrl(Url url){
            this.url = url;
        }
        public Url getUrl(){
            return this.url;
        }
        public void setAuthor(Author author){
            this.author = author;
        }
        public Author getAuthor(){
            return this.author;
        }
        public void setStory_text(Story_text story_text){
            this.story_text = story_text;
        }
        public Story_text getStory_text(){
            return this.story_text;
        }
    }


    public class Hits
    {
        private String created_at;

        private String title;

        private String url;

        private String author;

        private int points;

        private String story_text;

        private String comment_text;

        private int num_comments;

        private String story_id;

        private String story_title;

        private String story_url;

        private String parent_id;

        private int created_at_i;

        private int relevancy_score;

        private List<String> _tags;

        private String objectID;

        private _highlightResult _highlightResult;

        public void setCreated_at(String created_at){
            this.created_at = created_at;
        }
        public String getCreated_at(){
            return this.created_at;
        }
        public void setTitle(String title){
            this.title = title;
        }
        public String getTitle(){
            return this.title;
        }
        public void setUrl(String url){
            this.url = url;
        }
        public String getUrl(){
            return this.url;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        public String getAuthor(){
            return this.author;
        }
        public void setPoints(int points){
            this.points = points;
        }
        public int getPoints(){
            return this.points;
        }
        public void setStory_text(String story_text){
            this.story_text = story_text;
        }
        public String getStory_text(){
            return this.story_text;
        }
        public void setComment_text(String comment_text){
            this.comment_text = comment_text;
        }
        public String getComment_text(){
            return this.comment_text;
        }
        public void setNum_comments(int num_comments){
            this.num_comments = num_comments;
        }
        public int getNum_comments(){
            return this.num_comments;
        }
        public void setStory_id(String story_id){
            this.story_id = story_id;
        }
        public String getStory_id(){
            return this.story_id;
        }
        public void setStory_title(String story_title){
            this.story_title = story_title;
        }
        public String getStory_title(){
            return this.story_title;
        }
        public void setStory_url(String story_url){
            this.story_url = story_url;
        }
        public String getStory_url(){
            return this.story_url;
        }
        public void setParent_id(String parent_id){
            this.parent_id = parent_id;
        }
        public String getParent_id(){
            return this.parent_id;
        }
        public void setCreated_at_i(int created_at_i){
            this.created_at_i = created_at_i;
        }
        public int getCreated_at_i(){
            return this.created_at_i;
        }
        public void setRelevancy_score(int relevancy_score){
            this.relevancy_score = relevancy_score;
        }
        public int getRelevancy_score(){
            return this.relevancy_score;
        }
        public void set_tags(List<String> _tags){
            this._tags = _tags;
        }
        public List<String> get_tags(){
            return this._tags;
        }
        public void setObjectID(String objectID){
            this.objectID = objectID;
        }
        public String getObjectID(){
            return this.objectID;
        }
        public void set_highlightResult(_highlightResult _highlightResult){
            this._highlightResult = _highlightResult;
        }
        public _highlightResult get_highlightResult(){
            return this._highlightResult;
        }
    }


    public class Root
    {
        private List<Hits> hits;

        private int nbHits;

        private int page;

        private int nbPages;

        private int hitsPerPage;

        private boolean exhaustiveNbHits;

        private String query;

        private String params;

        private int processingTimeMS;

        public void setHits(List<Hits> hits){
            this.hits = hits;
        }
        public List<Hits> getHits(){
            return this.hits;
        }
        public void setNbHits(int nbHits){
            this.nbHits = nbHits;
        }
        public int getNbHits(){
            return this.nbHits;
        }
        public void setPage(int page){
            this.page = page;
        }
        public int getPage(){
            return this.page;
        }
        public void setNbPages(int nbPages){
            this.nbPages = nbPages;
        }
        public int getNbPages(){
            return this.nbPages;
        }
        public void setHitsPerPage(int hitsPerPage){
            this.hitsPerPage = hitsPerPage;
        }
        public int getHitsPerPage(){
            return this.hitsPerPage;
        }
        public void setExhaustiveNbHits(boolean exhaustiveNbHits){
            this.exhaustiveNbHits = exhaustiveNbHits;
        }
        public boolean getExhaustiveNbHits(){
            return this.exhaustiveNbHits;
        }
        public void setQuery(String query){
            this.query = query;
        }
        public String getQuery(){
            return this.query;
        }
        public void setParams(String params){
            this.params = params;
        }
        public String getParams(){
            return this.params;
        }
        public void setProcessingTimeMS(int processingTimeMS){
            this.processingTimeMS = processingTimeMS;
        }
        public int getProcessingTimeMS(){
            return this.processingTimeMS;
        }
    }

}
