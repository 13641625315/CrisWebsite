package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.facades.CrisWSFacades;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.ConfigurationUtil;
import com.cris.website.util.CusAccessObjectUtil;

@Controller
public class PageController {
	
	@Resource
	CrisWSFacades crisWSFacades;
	
	@RequestMapping(value="index")
    public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response,Model model){
		HeWeather heWeather=crisWSFacades.getWeatherForIP(CusAccessObjectUtil.getIpAddress(request));
		model.addAttribute("pageTitle", "首页");
		model.addAttribute("heWeather", heWeather);
        return new ModelAndView("indexPage");
    }
}
