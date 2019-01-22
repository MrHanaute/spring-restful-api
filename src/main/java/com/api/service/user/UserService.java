package com.api.service.user;

import com.api.model.user.User;
import com.api.model.user.UserRequestModel;

public interface UserService {
	User createUser(UserRequestModel userReq);
}
