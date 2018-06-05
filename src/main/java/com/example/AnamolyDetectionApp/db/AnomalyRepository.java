package com.example.AnamolyDetectionApp.db;

import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;


public interface AnomalyRepository extends MongoRepository<Anomaly,String> {

	public Anomaly findByid(String id);
//	public Anomaly findByanomaly(HashMap<String,Integer> anomaly);
	
	
}
