/**
 *
 */
package com.cris.website.client;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cris.website.exception.JsonConverterException;
import com.cris.website.jasonbean.HeWeather;
import com.cris.website.util.ConfigurationUtil;
import com.cris.website.util.JacksonHelper;

@Component
public class HeFengWeatherClient {
	private RestTemplate restTemplate;
	private ConfigurationUtil configurationUtil;

	public HeWeather getWeatherForIP(final String ip) {
		// String
		// responseBody=restTemplate.getForObject("https://free-api.heweather.com/v5/now?city=210.13.112.211&key=a00e1da7db394e0a8f6b6c30c665482b",
		// String.class);
		System.out.println(configurationUtil.HEFENG_WEATHER_URL);
		System.out.println(configurationUtil.HEFENG_WEATHER_KEY);
		String responseBody = restTemplate.getForObject(
				"https://free-api.heweather.com/v5/now?city=210.13.112.211&key=a00e1da7db394e0a8f6b6c30c665482b",
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

	public ConfigurationUtil getConfigurationUtil() {
		return configurationUtil;
	}

	public void setConfigurationUtil(ConfigurationUtil configurationUtil) {
		this.configurationUtil = configurationUtil;
	}

}
