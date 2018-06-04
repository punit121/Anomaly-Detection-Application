package com.example.AnamolyDetectionApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.AnamolyDetectionApp.PostAdRepository;
import com.example.AnamolyDetectionApp.PostAd;


@Component
public class UpdateRepository {
	@Autowired
	PostAdRepository repository2;
	
	public boolean updateDatabase(PostAd post1,String change){
		
		//PostAd post1 = repository2.findByid(id);
		
		post1.setCondition(change);
		//repository2.save(post1);
		return true;
	}
	
	
}
