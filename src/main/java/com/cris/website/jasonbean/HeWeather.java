/**
  * Copyright 2017 bejson.com 
  */
package com.cris.website.jasonbean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Auto-generated: 2017-09-04 15:28:1
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class HeWeather {

	@JsonProperty("HeWeather5")
	private List<HeWeather5> heWeather5;

	public void setHeWeather5(List<HeWeather5> heWeather5) {
		this.heWeather5 = heWeather5;
	}

	@JsonIgnore
	public List<HeWeather5> getHeWeather5() {
		return heWeather5;
	}

}