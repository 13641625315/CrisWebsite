package com.cris.website.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cris.website.dao.UserDao;
import com.cris.website.dao.UserGroupDao;
import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;
import com.cris.website.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserGroupDao userGroupDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	private static String USER_USER_GROUP_NAME = "User";

	@Override
	public UserModel findUserByPhoneNum(String phoneNum) {
		return userDao.findByPhoneNum(phoneNum);
	}

	@Override
	public UserGroupModel findUserGroupByGroupName(String groupName) {
		return userGroupDao.findByGroupName(groupName);
	}

	@Override
	public boolean userRegist(String phoneNum, String nickName, String pass, String repass, String idCode)
			throws Exception {
		UserGroupModel userGroup = findUserGroupByGroupName(USER_USER_GROUP_NAME);
		if (null == userGroup) {
			return false;
		}
		// TODO Add validator http://www.yuntongxun.com/doc.html 短信验证码
		UserModel user = new UserModel();
		user.setNickName(nickName);
		user.setPassword(md5PasswordEncoder.encodePassword(pass, phoneNum));
		user.setPhoneNum(phoneNum);
		user.setIsActive(true);
		List<UserGroupModel> userGroups = new ArrayList<>();
		userGroups.add(userGroup);
		user.setUserGroups(userGroups);
		userDao.save(user);
		return true;
	}

}
