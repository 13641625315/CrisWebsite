package com.cris.website.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConfigurationUtil {
	// HeFeng Weather
	@Value("#{configs['hefeng.weather.url']}")
	public String HEFENG_WEATHER_URL;
	@Value("#{configs['hefeng.weather.key']}")
	public String HEFENG_WEATHER_KEY;
}