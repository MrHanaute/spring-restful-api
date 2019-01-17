package com.api.shared;

import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class Utils {

	public String generatedUserId() {
		
		return UUID.randomUUID().toString();

	}
	
}
