package com.cris.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.dao.UserDao;
import com.cris.website.dao.UserGroupDao;

@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	@Autowired
	UserDao userDao;
	@Autowired
	UserGroupDao userGroupDao;
	
	@RequestMapping(value = "/testPage", method = RequestMethod.GET)
	public ModelAndView testPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		System.out.println(userDao.findByPhoneNum("13641625315").getNickName());
		System.out.println(userGroupDao.findByGroupName("Admin").getGroupName());
		model.addAttribute("pageTitle", "测试页");
		return new ModelAndView("testPage");
	}

	@RequestMapping(value = "/log", method = RequestMethod.GET)
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		final Log log = LogFactory.getLog(getClass());
		log.info("TEST PAGE!" + System.getProperty("CrisWebsiteRootKey"));
		log.debug("TEST PAGE!");
		log.error("TEST PAGE!");
		model.addAttribute("pageTitle", "测试页");
		return new ModelAndView("testPage");
	}
}
