/**
 * 
 */
package com.impaq.ic.spring.javaconfig.tv.weather;

/**
 * @author Lukasz
 * 
 */
public class WeatherBean implements WeatherService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.impaq.ic.spring.javaconfig.WeatherService#getWeatherForesee()
	 */
	@Override
	public String getWeatherForesee() {
		return "w";
	}

}
