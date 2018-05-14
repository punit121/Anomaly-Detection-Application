package com.example.AnamolyDetectionApp.Controller;

import java.util.Map;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnamolyDetectionAppController {

	@RequestMapping("/sample")
    public Map<String,String> sample(@RequestParam(value="name", defaultValue="World") String name) {
    Map<String,String> result = new HashMap<>();
    result.put("message", String.format("Hello, %s", name));
    return result;
    }
	
	
}
