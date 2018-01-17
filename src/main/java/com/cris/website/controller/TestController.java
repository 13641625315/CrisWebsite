package com.cris.website.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	
	@RequestMapping(value="test")
    public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response,Model model){
		model.addAttribute("pageTitle", "测试页");
        return new ModelAndView("testPage");
    }
}
