package com.api.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String generateId(){
		return UUID.randomUUID().toString();
	}

	public String generatedUserId() {
		
		return this.generateId();

	}
	
}
