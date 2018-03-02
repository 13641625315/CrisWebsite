package com.cris.website.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.authentication.encoding.Md5PasswordEncoder;

import com.cris.website.dao.UserDao;
import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDaoImpl;
	private Md5PasswordEncoder md5PasswordEncoder;

	private static String USER_USER_GROUP_NAME = "User";

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		return userDaoImpl.findUserByPhoneNum(phoneNum);
	}

	@Override
	public UserGroupModel findUserGroupByGroupName(String userGroupName) {
		return userDaoImpl.findUserGroupByGroupName(userGroupName);
	}

	@Override
	public boolean UserRegist(String phoneNum, String nickName, String pass, String repass, String idCode)
			throws Exception {
		UserGroupModel userGroup = findUserGroupByGroupName(USER_USER_GROUP_NAME);
		if (null == userGroup) {
			return false;
		}
		// TODO add Validator
		// TODO http://www.yuntongxun.com/doc.html 短信验证码
		UserModel user = new UserModel();
		user.setNickName(nickName);
		user.setPassword(md5PasswordEncoder.encodePassword(pass, phoneNum));
		user.setPhoneNum(phoneNum);
		user.setIsActive(true);
		List<UserGroupModel> userGroups = new ArrayList<>();
		userGroups.add(userGroup);
		user.setUserGroups(userGroups);
		userDaoImpl.saveModel(user);
		return true;
	}

	public UserDao getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDao userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public Md5PasswordEncoder getMd5PasswordEncoder() {
		return md5PasswordEncoder;
	}

	public void setMd5PasswordEncoder(Md5PasswordEncoder md5PasswordEncoder) {
		this.md5PasswordEncoder = md5PasswordEncoder;
	}

}
