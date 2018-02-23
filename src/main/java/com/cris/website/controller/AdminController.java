package com.cris.website.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.dao.CrisAbstractDao;
import com.cris.website.model.UserGroupModel;
import com.cris.website.model.UserModel;;

@Controller
public class AdminController {

	@Resource
	private CrisAbstractDao crisAbstractDaoImpl;

	@RequestMapping(value = "/initialData")
	public ModelAndView initialData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		// initial usergroup
		UserGroupModel userGroup = new UserGroupModel();
		userGroup.setGroupname("Admin");
		// initial user
		UserModel user = new UserModel();
		user.setNickName("cris");
		user.setPassword("cris1234");
		user.setPhoneNum("13641625315");
		user.setIsActive(true);
		List<UserGroupModel> userGroups = new ArrayList<>();
		userGroups.add(userGroup);
		user.setUserGroups(userGroups);
		crisAbstractDaoImpl.saveModel(user);
		return new ModelAndView("redirect:/indexPage");
	}

}
