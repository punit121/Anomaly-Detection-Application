package com.example.AnamolyDetectionApp.Controller;

import java.util.*;


import javax.swing.text.html.HTMLDocument.Iterator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.AnamolyDetectionApp.AnamolyDetectionAppApplication;
import com.example.AnamolyDetectionApp.CheckAnamoly;
import com.example.AnamolyDetectionApp.PostAdEventRequest;
import com.example.AnamolyDetectionApp.Request;
//import com.example.AnamolyDetectionApp.PostAdRepository;
import com.example.AnamolyDetectionApp.UpdateRepository;
import com.example.AnamolyDetectionApp.db.AnomalyRepository;
import com.example.AnamolyDetectionApp.db.Anomaly;

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
	AnomalyRepository anomalyrepository;
	

	@RequestMapping(value="/postad", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Integer> getID(@RequestBody Request request) {
		//Map<String, Integer> anamoly;
		System.out.println("Request" + request.getEvent());
			try{
			    	Map<String, Integer> anamoly =  	run(request.getData());
			    	return anamoly;
			    }catch(Exception e) {
			    	
			    }
			return null;
			  	
			}
	
	@SuppressWarnings("rawtypes")
	public Map<String, Integer> run (PostAdEventRequest request) throws Exception{
		
			 //id =  id;
			//PostAd post1 = repository.findByid(id);
			String id = request.getId();
			String title = request.getTitle();
			String description = request.getDescription(); 
			// Checking Anamoly in the PostAd

			Map<String, Integer> anamoly = checkAnamoly.CheckAnamolyById(title,description);
			Map.Entry<String, Integer> firstEntry = anamoly.entrySet().iterator().next();
			Integer largestKey = firstEntry.getValue();
			String largestKeyValue = firstEntry.getKey();
			int count = 0;
			for (Map.Entry<String, Integer> map : anamoly.entrySet()) {
			    int key = map.getValue();
			    if (key > largestKey) {
				largestKey = key;
				largestKeyValue = map.getKey();
				
			    }
			    count++;
			}
			
			/*System.out.println("Largest Key       : " + largestKey);
			System.out.println("Largest Key Value : " + largestKeyValue);
			System.out.println(Arrays.asList(anamoly));
			*/
			anomalyrepository.save(new Anomaly(id, anamoly));
	        //updating the database 
			
	        int t=count-1;
	        if (t>=1 ) {
	  
	        	String condition = request.getCondition();
	        	if(condition.equals("Brand New")) {
	        		System.out.println("Almost like New");
	        		//UpdateRepository update = new UpdateRepository();
	        		//boolean result = update.updateDatabase(post1,"Almost Like New");
	        		
	        		/*if(result == true) {
	        			//repository.save(post1);	
	        			System.out.println("Task done");
	        		}*/
	        		
	        		
	        	}
	           
	        }
	        else {
	        	
	        }
	        // Call Python API 
	        
	        
	        Map<String, Integer> result = new HashMap<>();
			result.put(largestKeyValue,largestKey);
			return anamoly;
	        
	        

		}
	}


