package com.codeversus.backend.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class HealthController {
	
	@GetMapping("/health")
	public Map<String,String> health(){
		HashMap<String,String> map = new HashMap<>();
		
		map.put("status", "UP");
		map.put("service", "code-versus-api");
		map.put("application", "Code Versus");
		
		return map;
	}
	

}
