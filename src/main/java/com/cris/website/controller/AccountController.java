package com.cris.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.service.UserService;

@Controller
public class AccountController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/userRegist", method = RequestMethod.POST)
	public ModelAndView userRegist(@RequestParam String phoneNum, @RequestParam String nickName,
			@RequestParam String pass, @RequestParam String repass, @RequestParam String idCode,
			HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {
		userService.userRegist(phoneNum, nickName, pass, repass, idCode);
		return new ModelAndView("redirect:/loginPage");
	}
}