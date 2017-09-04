package com.cris.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	private final static Logger LOG = LoggerFactory.getLogger(TestController.class);
	
	@RequestMapping(value="test")
    public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response){
        return new ModelAndView("indexPage");
    }
}

