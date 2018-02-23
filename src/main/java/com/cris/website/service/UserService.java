package com.cris.website.service;

import com.cris.website.model.UserModel;

public interface UserService {
	public abstract UserModel findUserByPhoneNum(String phoneNum);
}
