package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.client.HeFengWeatherClient;
import com.cris.website.util.CusAccessObjectUtil;

@Controller
public class PageController {
	
	private final static Logger LOG = LoggerFactory.getLogger(PageController.class);
	

	@Resource
	HeFengWeatherClient heFengWeatherClient;
	
	@RequestMapping(value="index")
    public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response){
		heFengWeatherClient.getWeatherForIP(CusAccessObjectUtil.getIpAddress(request));
        return new ModelAndView("indexPage");
    }
}
