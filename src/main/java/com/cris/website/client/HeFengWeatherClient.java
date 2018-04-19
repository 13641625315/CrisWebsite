/**
 *
 */
package com.cris.website.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.JacksonHelper;

@Component
public class HeFengWeatherClient {
	@Autowired
	private RestTemplate restTemplate;
	private static String HEFENG_WEATHER_URL;
	private static String HEFENG_WEATHER_KEY;

	public HeWeather getWeatherForIP(final String ip) throws JsonConverterException {
		String HEFENG_WEATHER_GET_REQUEST = HEFENG_WEATHER_URL + "?city=" + ip + "&key=" + HEFENG_WEATHER_KEY;
		String responseBody = restTemplate.getForObject(HEFENG_WEATHER_GET_REQUEST, String.class);
		return JacksonHelper.fromJSON(responseBody, HeWeather.class);
	}

	public String getHEFENG_WEATHER_URL() {
		return HEFENG_WEATHER_URL;
	}

	public void setHEFENG_WEATHER_URL(String hEFENG_WEATHER_URL) {
		HEFENG_WEATHER_URL = hEFENG_WEATHER_URL;
	}

	public String getHEFENG_WEATHER_KEY() {
		return HEFENG_WEATHER_KEY;
	}

	public void setHEFENG_WEATHER_KEY(String hEFENG_WEATHER_KEY) {
		HEFENG_WEATHER_KEY = hEFENG_WEATHER_KEY;
	}
}
