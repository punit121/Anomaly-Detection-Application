package com.example.AnamolyDetectionApp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


public class PostAd {

	@Id
	public String id;
	public String title;
	public String description;
	public String condition;
	
	public PostAd() {}
	
	public PostAd(String title,String description,String condition) {
		this.title = title;
		this.description= description;
		this.condition= condition;
		
	}
	
	public String getId() {
		return id;
	}
	public String getTitle() {
        return title;
    }
	public String getDescription() {
        return description;
    }
	public String getCondition() {
        return condition;
    }
    public void setCondition(String condition) {
        this.condition = condition;
    }
	
	
	@Override
    public String toString() {
        return String.format(
                "PostAd[id=%s, title='%s', description='%s', condition='%s']",
                id, title, description,condition);
    }
	
}
