package com.example.AnamolyDetectionApp.Controller;

import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AnamolyDetectionApp.AnamolyDetectionAppApplication;
import com.example.AnamolyDetectionApp.CheckAnamoly;
import com.example.AnamolyDetectionApp.PostAd;
import com.example.AnamolyDetectionApp.PostAdRepository;
import com.example.AnamolyDetectionApp.UpdateRepository;

@RestController
public class AnamolyDetectionAppController {

	@RequestMapping("/sample")
	public Map<String, String> sample(@RequestParam(value = "name", defaultValue = "World") String name) {
		Map<String, String> result = new HashMap<>();
		result.put("message", String.format("Hello, %s", name));
		return result;
	}
	@Autowired
	CheckAnamoly checkAnamoly;
	

	@Autowired
	PostAdRepository repository;
	@RequestMapping(value="/getid", method = RequestMethod.GET)
	@ResponseBody
	public String getID( String id) {
			    try{
			    	run(id);
			    }catch(Exception e) {
			    	
			    }
			    return "Yahoo";
			}
	
	public void run (String id) throws Exception{
		
			 //id =  id;
			PostAd post1 = repository.findByid(id);
			
			// Checking Anamoly in the PostAd

	    	int t = checkAnamoly.CheckAnamolyById(post1);
	    
	        //updating the database 
	        
	        if (t>=1 ) {
	  
	        	String strr3 = post1.getCondition();
	        	if(strr3.equals("Brand New")) {
	        		System.out.println("Almost like New");
	        		UpdateRepository update = new UpdateRepository();
	        		boolean result = update.updateDatabase(post1,"Almost Like New");
	        		
	        		if(result == true) {
	        			repository.save(post1);	
	        			System.out.println("Task done");
	        		}
	        		
	        		
	        	}
	           
	        }
	        else {
	        	
	        }
	        // Call Python API 
	        
	        
	        
	        
	        

		}
	}


