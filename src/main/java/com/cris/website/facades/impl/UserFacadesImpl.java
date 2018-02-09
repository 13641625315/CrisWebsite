package com.cris.website.facades.impl;

import com.cris.website.data.UserData;
import com.cris.website.facades.UserFacades;
import com.cris.website.model.User;
import com.cris.website.service.UserService;

public class UserFacadesImpl implements UserFacades {
	private UserService userServiceImpl;

	@Override
	public UserData findUserByPhoneNum(String phoneNum) {
		User user = userServiceImpl.findUserByPhoneNum(phoneNum);
		UserData userData = new UserData();
		userData.setNickName(user.getNickName());
		userData.setPhoneNum(user.getPhoneNum());
		userData.setPassword(user.getPassword());
		return userData;
	}

	public UserService getUserServiceImpl() {
		return userServiceImpl;
	}

	public void setUserServiceImpl(UserService userServiceImpl) {
		this.userServiceImpl = userServiceImpl;
	}

}
