package com.example.AnamolyDetectionApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author punit
 *
 */

@RestController
@SpringBootApplication
public class AnamolyDetectionAppApplication  {
	

	
	
	


	
	//private String id;
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(AnamolyDetectionAppApplication.class, args);
	}
	
	
	
}
