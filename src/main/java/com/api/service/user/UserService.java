package com.api.service.user;

import com.api.model.User;
import com.api.model.UserRequestModel;

public interface UserService {
	User createUser(UserRequestModel userReq);
}
