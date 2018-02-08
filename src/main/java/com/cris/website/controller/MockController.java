package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.CusAccessObjectUtil;

@Controller
public class MockController {

	@Resource
	CrisWSFacades crisWSFacades;

	@RequestMapping(value = "/mock")
	public String indexPage(HttpServletRequest request, HttpServletResponse response, Model model)
			throws JsonConverterException {
		return null;
	}

}