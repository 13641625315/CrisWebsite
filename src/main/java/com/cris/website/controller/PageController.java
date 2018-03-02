package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.CusAccessObjectUtil;

@Controller
public class PageController {
	private static String PAGE_TITLE_PREFIX = "CRIS" + " " + "|" + " ";

	@Resource
	CrisWSFacades crisWSFacades;

	@RequestMapping(value = "/indexPage", method = RequestMethod.GET)
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		HeWeather heWeather = crisWSFacades.getWeatherForIP(CusAccessObjectUtil.getPublicIP());
		model.addAttribute("pageTitle", PAGE_TITLE_PREFIX + "首页");
		model.addAttribute("pageID", "indexPage");
		model.addAttribute("heWeather", heWeather);
		return new ModelAndView("indexPage");
	}

	@RequestMapping(value = "/loginPage", method = RequestMethod.GET)
	public ModelAndView loginPage(HttpServletRequest request, HttpServletResponse response, Boolean authenticated,
			Model model) {
		if (null != authenticated && !authenticated) {
			model.addAttribute("loginError", "用户名密码不正确,或者权限不够");
		}
		model.addAttribute("pageTitle", PAGE_TITLE_PREFIX + "登入注册");
		model.addAttribute("pageID", "loginPage");
		return new ModelAndView("loginPage");
	}

	@RequestMapping(value = "/adminPage", method = RequestMethod.GET)
	public ModelAndView adminPage(HttpServletRequest request, HttpServletResponse response, Model model) {
		model.addAttribute("pageTitle", PAGE_TITLE_PREFIX + "管理");
		return new ModelAndView("adminPage");
	}
}
