package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.CusAccessObjectUtil;
import com.cris.website.util.JacksonHelper;

@Controller
public class TestController {

	@Resource
	CrisWSFacades crisWSFacades;

	@RequestMapping(value = "test")
	public ModelAndView indexPage(HttpServletRequest request, HttpServletResponse response, Model model)
			throws JsonConverterException {
		HeWeather heWeather = crisWSFacades.getWeatherForIP(CusAccessObjectUtil.getIpAddress(request));
		model.addAttribute("pageTitle", "首页");
		model.addAttribute("heWeather", heWeather);
		return new ModelAndView("testPage");
	}
}