package com.example.AnamolyDetectionApp;

import org.springframework.data.annotation.Id;


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
	@Override
    public String toString() {
        return String.format(
                "PostAd[id=%s, title='%s', description='%s', condition='%s']",
                id, title, description,condition);
    }
	
}
