package com.example.AnamolyDetectionApp;


//import com.c2c.vo.AdPArtialAttributeUpdateFeatureFlag;
//import com.escrow.qps.QuikrPreferredSellerHelper;
//import com.escrow.util.Utils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.jayway.jsonpath.internal.Utils;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Request {
	String event;
	@JsonProperty("data")
	PostAdEventRequest data;
	
	public PostAdEventRequest getData() {
		
		return this.data;
		
	}
	public void setData(PostAdEventRequest data) {
		this.data=data;
	}
	
	public void setEvent(String event) {
		this.event = event;
	}
	
	public String getEvent() {
		return this.event;
	}
	
	
	
}