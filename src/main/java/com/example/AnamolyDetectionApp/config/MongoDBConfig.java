package com.example.AnamolyDetectionApp.config;

import com.example.AnamolyDetectionApp.db.AnomalyRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@PropertySource("classpath:${spring.profiles.active}/mongodb.properties")
@EnableMongoRepositories(basePackageClasses = AnomalyRepository.class ,mongoTemplateRef = "mongoTemplate")
public class MongoDBConfig {

}
