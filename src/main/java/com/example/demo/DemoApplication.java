package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	 @Bean
	    CommandLineRunner init(DomainRepository domainRepository) {

	        return args -> {

	            Domain obj = domainRepository.findOne(7L);
	            System.out.println(obj);

	            Domain obj2 = domainRepository.findFirstByDomain("mkyong.com");
	            System.out.println(obj2);

	            int n = domainRepository.updateDomain("mkyong.com", true);
	            System.out.println("Number of records updated : " + n);

	        };

	    }
}


