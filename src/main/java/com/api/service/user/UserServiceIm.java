package com.api.service.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.model.user.User;
import com.api.model.user.UserRequestModel;
import com.api.shared.Utils;

@Service
public class UserServiceIm implements UserService {
	Map<String, User> users;
	
	Utils utils;
	
	public UserServiceIm() {}
	
	@Autowired
	public UserServiceIm(Utils utils) {
		this.utils = utils;
	}
	
	
	@Override
	public User createUser(UserRequestModel userReq) {
		User user = new User();
		user.setName(userReq.getName());
		user.setAge(userReq.getAge());
		user.setEmail(userReq.getEmail());
		
		String userId = utils.generatedUserId();
		user.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, user);
		
		return user;
	}

}
