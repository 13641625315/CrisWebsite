package com.cris.website.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.JacksonHelper;

@Controller
public class TestController {
	
	@Resource
	RestTemplate restTemplate;
	
	@RequestMapping(value="test")
    public ModelAndView indexPage(HttpServletRequest request,HttpServletResponse response) throws JsonConverterException{
		String string="{\"HeWeather5\":[{\"basic\":{\"city\":\"上海\",\"cnty\":\"中国\",\"id\":\"CN101020100\",\"lat\":\"31.23170662\",\"lon\":\"121.47264099\",\"update\":{\"loc\":\"2017-09-05 14:46\",\"utc\":\"2017-09-05 06:46\"}},\"now\":{\"cond\":{\"code\":\"101\",\"txt\":\"多云\"},\"fl\":\"37\",\"hum\":\"60\",\"pcpn\":\"0\",\"pres\":\"1006\",\"tmp\":\"33\",\"vis\":\"6\",\"wind\":{\"deg\":\"96\",\"dir\":\"东风\",\"sc\":\"微风\",\"spd\":\"4\"}},\"status\":\"ok\"}]}";
		HeWeather heWeather=JacksonHelper.fromJSON(string, HeWeather.class);
        return new ModelAndView("indexPage");
    }
}

