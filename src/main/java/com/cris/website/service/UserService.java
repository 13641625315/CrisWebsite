package com.cris.website.service;

import com.cris.website.model.User;

public interface UserService {
	public abstract User findUserByPhoneNum(String phoneNum);
}
