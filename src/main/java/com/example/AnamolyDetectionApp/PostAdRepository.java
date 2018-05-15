package com.example.AnamolyDetectionApp;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostAdRepository extends MongoRepository<PostAd,String>{
	
	public PostAd findByid(String id);
	public PostAd findBytitle(String title);
	public PostAd findBydescription(String title);
	public PostAd findBycondition(String title);

}
