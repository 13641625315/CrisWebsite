package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.data.UserData;
import com.cris.website.facades.UserFacades;

@Controller
public class AccountController {

	@Resource
	private UserFacades userFacades;

	@RequestMapping(value = "/userLogin", method = RequestMethod.POST)
	public ModelAndView userLogin(@RequestParam String phoneNum, @RequestParam String pass, HttpServletRequest request,
			HttpServletResponse response, Model model) throws Exception {
		UserData userData = userFacades.findUserByPhoneNum(phoneNum);
		System.out.println(userData.toString());
		return new ModelAndView("redirect:/indexPage");
	}

}
