package com.example.AnamolyDetectionApp;

import java.io.*;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils; 

//import org.springframework.util.StringUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.AnamolyDetectionApp.PostAd;
//import com.jayway.jsonpath.internal.Utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@Service
@Configuration
@PropertySource("classpath:config.properties")
public class CheckAnamoly {
	
	@Value("${data}")
	private String data; 

	private List<String> anomaliesWordList ;
	
	@PostConstruct
	public void init() {
		anomaliesWordList = Arrays.asList(data.split(","));
	}
	
	public CheckAnamoly() {}
	
	public  int weightProduct(int count,List<String> s2) {
		int a=s2.size();
		
		if(count>=a/2) {
			return 4;
		}
		else if(count>=a/6 && count<a/2) {
			return 3;
		}
		else if(count>a/10 && count<a/6) {
			return 2;
		}
		
		return 1; 
	}
	
	public Map<String, Integer> checkEqualityScore(String str1, List<String> s2) {
		int count = 0;

		if (str1.isEmpty() || s2.isEmpty()) {
			return null;
		}
		int n1 = s2.size();
		// initiating hashmap to store all matches
		HashMap<String, Integer> anomaly = new HashMap<String, Integer>();
		anomaly.put("null",0);
		
		for (int i = 0; i < n1; i++) {

			String search = s2.get(i);
			if (str1.indexOf(search.toLowerCase()) != -1) {
				// System.out.println("I found the keyword");
				int total = StringUtils.countMatches(str1,search);
				count++;
				anomaly.put(search,total);
			}

		}

		return anomaly;
	}
	public Map<String, Integer> CheckAnamolyById(PostAd post1) throws FileNotFoundException{
				
		String title= post1.getTitle();
    	String description = post1.getDescription();
    	//String strr3 = post1.getCondition();
    	StringBuilder builder = new StringBuilder();
    	builder.append(title+" ");
    	builder.append(description);
    	String str= builder.toString();
    	String str1 = str.toLowerCase();
    	
        //data = data.replaceAll(",", " ");
        //String s2[] = { "days old","months old","years old","month old","year old","good condition","new condition","excellent condition","proper condition","perfect condition","working condition","barely used","used only","hardly used","gently used","rarely used","damage","without even a single scratch","without a scratch","without scratch","extremely good","scratchless","almost new","like new"};
       // String[] s2= data1.split(" ");
        //System.out.println(str1);
      
        Map<String, Integer> anomalyscore  = checkEqualityScore(str1, anomaliesWordList);
       // int wt = weightProduct(t, anomaliesWordList);
        //System.out.println("equal characters ="+t);
        //System.out.println("weight count ="+wt);
       
        return anomalyscore;
       /* if (t>=1 ) {
        	if(strr3.equals("Brand New")) {
        		System.out.println("Almost like New");
        		post1.setCondition("Almost Like New");
        		repository.save(post1);
        		System.out.println("Task done");
        		
        	}
            //System.out.println("Almost like New");
        }
        */

	}
	
}
