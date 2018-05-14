package com.example.AnamolyDetectionApp;

import org.springframework.http.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 
 * @author punit
 *
 */

@RestController
@SpringBootApplication
public class AnamolyDetectionAppApplication  implements CommandLineRunner {
	
	@RequestMapping(value = "/", produces = MediaType.TEXT_HTML_VALUE)
    public String home() {
        return "Nothing here. Go to <a href='/sample'>/sample</a>";
    }

	@Autowired
	private PostAdRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(AnamolyDetectionAppApplication.class, args);
	}
	
	public static int weightProduct(int count,String[] s2) {
		int a=s2.length;
		
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
	
	
	public static int checkEquality(String[] s1, String[] s2) {
        int count=0;
		

        if (s1 == null || s2 == null)
            return 0;

		int n = s1.length;
        int n1=s2.length;

        for (int i = 0; i < n; i++) {
        	for(int j=0;j<n1;j++) {
            if (s1[i].equals(s2[j]))
            	count++;
                //return true;
        }
        }

        return count;
    }
	@Override
	public void run(String... args) throws Exception {
		String strr1= "4 year old";
    	String strr2 = "I am punit";
    	StringBuilder builder = new StringBuilder();
    	builder.append(strr1+" ");
    	builder.append(strr2);
    	String str= builder.toString();
    	
    	
        String[] s1=str.split(" ");
        String data = "days old,months old,years old,month old,year old,good condition,new condition,excellent condition,proper condition,perfect condition,working condition,barely used,used only,hardly used,gently used,rarely used,damage,without even a single scratch,without a scratch,without scratch,extremely good,scratchless,almost new,like new";
        data = data.replaceAll(",", " ");
        String[] s2= data.split(" ");
        System.out.println(str);
      
        int t= checkEquality(s1,s2);
        int wt= weightProduct(t,s2);
        System.out.println("equal characters ="+t);
        System.out.println("weight count ="+wt);
       
        if (t>1)
            System.out.println("Almost like New");
        else
            System.out.println("Not New");
		//repository.deleteAll();
		//repository.save(new PostAd("New Car", "Best Car of all Time","Brand New"));
		
		
		
		/*
		// save a couple of customers
		repository.save(new Customer("Alice", "Smith"));
		repository.save(new Customer("Bob", "Smith"));

		// fetch all customers
		System.out.println("Customers found with findAll():");
		System.out.println("-------------------------------");
		for (Customer customer : repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		// fetch an individual customer
		System.out.println("Customer found with findByFirstName('Alice'):");
		System.out.println("--------------------------------");
		System.out.println(repository.findByFirstName("Alice"));

		System.out.println("Customers found with findByLastName('Smith'):");
		System.out.println("--------------------------------");
		for (Customer customer : repository.findByLastName("Smith")) {
			System.out.println(customer);
		}
		*/
	}
}