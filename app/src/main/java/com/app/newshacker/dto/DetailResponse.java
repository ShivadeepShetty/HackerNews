package com.app.newshacker.dto;

import java.util.List;

public class DetailResponse {

    public class Children
    {
        private int id;

        private String created_at;

        private int created_at_i;

        private String type;

        private String author;

        private String title;

        private String url;

        private String text;

        private String points;

        private int parent_id;

        private int story_id;

        private List<Children> children;

        private List<String> options;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCreated_at(String created_at){
            this.created_at = created_at;
        }
        public String getCreated_at(){
            return this.created_at;
        }
        public void setCreated_at_i(int created_at_i){
            this.created_at_i = created_at_i;
        }
        public int getCreated_at_i(){
            return this.created_at_i;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        public String getAuthor(){
            return this.author;
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
        public void setText(String text){
            this.text = text;
        }
        public String getText(){
            return this.text;
        }
        public void setPoints(String points){
            this.points = points;
        }
        public String getPoints(){
            return this.points;
        }
        public void setParent_id(int parent_id){
            this.parent_id = parent_id;
        }
        public int getParent_id(){
            return this.parent_id;
        }
        public void setStory_id(int story_id){
            this.story_id = story_id;
        }
        public int getStory_id(){
            return this.story_id;
        }
        public void setChildren(List<Children> children){
            this.children = children;
        }
        public List<Children> getChildren(){
            return this.children;
        }
        public void setOptions(List<String> options){
            this.options = options;
        }
        public List<String> getOptions(){
            return this.options;
        }
    }





    public class Root
    {
        private int id;

        private String created_at;

        private int created_at_i;

        private String type;

        private String author;

        private String title;

        private String url;

        private String text;

        private int points;

        private String parent_id;

        private String story_id;

        private List<Children> children;

        private List<String> options;

        public void setId(int id){
            this.id = id;
        }
        public int getId(){
            return this.id;
        }
        public void setCreated_at(String created_at){
            this.created_at = created_at;
        }
        public String getCreated_at(){
            return this.created_at;
        }
        public void setCreated_at_i(int created_at_i){
            this.created_at_i = created_at_i;
        }
        public int getCreated_at_i(){
            return this.created_at_i;
        }
        public void setType(String type){
            this.type = type;
        }
        public String getType(){
            return this.type;
        }
        public void setAuthor(String author){
            this.author = author;
        }
        public String getAuthor(){
            return this.author;
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
        public void setText(String text){
            this.text = text;
        }
        public String getText(){
            return this.text;
        }
        public void setPoints(int points){
            this.points = points;
        }
        public int getPoints(){
            return this.points;
        }
        public void setParent_id(String parent_id){
            this.parent_id = parent_id;
        }
        public String getParent_id(){
            return this.parent_id;
        }
        public void setStory_id(String story_id){
            this.story_id = story_id;
        }
        public String getStory_id(){
            return this.story_id;
        }
        public void setChildren(List<Children> children){
            this.children = children;
        }
        public List<Children> getChildren(){
            return this.children;
        }
        public void setOptions(List<String> options){
            this.options = options;
        }
        public List<String> getOptions(){
            return this.options;
        }
    }

}
