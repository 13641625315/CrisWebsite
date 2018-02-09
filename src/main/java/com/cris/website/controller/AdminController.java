package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.dao.CrisAbstractDao;
import com.cris.website.model.User;

@Controller
public class AdminController {

	@Resource
	private CrisAbstractDao crisAbstractDaoImpl;

	@RequestMapping(value = "/initialData")
	public ModelAndView initialData(HttpServletRequest request, HttpServletResponse response, Model model)
			throws Exception {
		User user = new User();
		user.setNickName("cris");
		user.setPassword("cris1234");
		user.setPhoneNum("13641625315");
		crisAbstractDaoImpl.saveModel(user);
		return new ModelAndView("redirect:/indexPage");
	}

}
