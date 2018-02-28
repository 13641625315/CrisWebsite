package com.cris.website.service.impl;

import com.cris.website.dao.UserDao;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDaoImpl;

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		return userDaoImpl.findUserByPhoneNum(phoneNum);
	}

	@Override
	public void saveUser(UserModel user) throws Exception {
		userDaoImpl.saveModel(user);
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

}
