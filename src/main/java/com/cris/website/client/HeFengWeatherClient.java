/**
 *
 */
package com.cris.website.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.JacksonHelper;

@Component
public class HeFengWeatherClient {
	private RestTemplate restTemplate;
	private String HEFENG_WEATHER_URL;
	private String HEFENG_WEATHER_KEY;

	public HeWeather getWeatherForIP(final String ip) {
		// String
		// responseBody=restTemplate.getForObject("https://free-api.heweather.com/v5/now?city=210.13.112.211&key=a00e1da7db394e0a8f6b6c30c665482b",
		// String.class);
		String HEFENG_WEATHER_GET_REQUEST=HEFENG_WEATHER_URL+"?city="+ip+"&key="+HEFENG_WEATHER_KEY;
		String responseBody = restTemplate.getForObject(HEFENG_WEATHER_GET_REQUEST,
				String.class);
		try {
			return JacksonHelper.fromJSON(responseBody, HeWeather.class);
		} catch (JsonConverterException e) {
			e.printStackTrace();
		}
		return null;
	}

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
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
