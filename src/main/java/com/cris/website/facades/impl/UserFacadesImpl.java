package com.cris.website.facades.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cris.website.data.UserData;
import com.cris.website.facades.UserFacades;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

@Component("userFacades")
public class UserFacadesImpl implements UserFacades {
	@Autowired
	private UserService userService;

	@Override
	public UserData findUserByPhoneNum(String phoneNum) {
		UserModel user = userService.findUserByPhoneNum(phoneNum);
		UserData userData = new UserData();
		userData.setNickName(user.getNickName());
		userData.setPhoneNum(user.getPhoneNum());
		userData.setPassword(user.getPassword());
		return userData;
	}

}
