package com.cris.website.service;

import com.cris.website.model.UserModel;

public interface UserService {
	public UserModel findUserByPhoneNum(String phoneNum);

	public void saveUser(UserModel user) throws Exception;
}
