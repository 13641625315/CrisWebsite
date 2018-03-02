package com.cris.website.service;

import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;

public interface UserService {
	public UserModel findUserByPhoneNum(String phoneNum);

	public UserGroupModel findUserGroupByGroupName(String userGroupName);

	public boolean UserRegist(String phoneNum, String nickName, String pass, String repass, String idCode) throws Exception;
}
