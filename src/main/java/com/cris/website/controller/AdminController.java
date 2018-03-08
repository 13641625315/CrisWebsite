package com.cris.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.dao.UserDao;
import com.cris.website.dao.UserGroupDao;
import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {

	@Autowired
	private UserDao userDao;
	@Autowired
	private UserGroupDao userGroupDao;
	@Autowired
	private Md5PasswordEncoder md5PasswordEncoder;

	private String SECURITYCODE = "admin";

	@RequestMapping(value = "/initialData", method = RequestMethod.GET)
	public ModelAndView initialData(HttpServletRequest request, HttpServletResponse response, Model model,
			String securityCode) throws Exception {
		if (SECURITYCODE.equals(securityCode)) {
			// initial UserGroupModel
			UserGroupModel userGroup = new UserGroupModel();
			userGroup.setGroupName("User");
			userGroupDao.save(userGroup);
			UserGroupModel adminGroup = new UserGroupModel();
			adminGroup.setGroupName("Admin");
			userGroupDao.save(adminGroup);
			// initial UserModel
			UserModel user = new UserModel();
			user.setNickName("Admin");
			user.setPassword(md5PasswordEncoder.encodePassword("nimda", "11111111111"));
			user.setPhoneNum("11111111111");
			user.setIsActive(true);
			List<UserGroupModel> userGroups = new ArrayList<>();
			userGroups.add(userGroup);
			userGroups.add(adminGroup);
			user.setUserGroups(userGroups);
			userDao.save(user);
		}
		return new ModelAndView("redirect:/indexPage");
	}

}
