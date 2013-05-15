package com.impaq.ic.spring.javaconfig.tv;

import com.impaq.ic.spring.javaconfig.tv.gossip.GossipServis;
import com.impaq.ic.spring.javaconfig.tv.stock.StockService;
import com.impaq.ic.spring.javaconfig.tv.weather.WeatherService;

public class TelevisionBean implements TelevisionService {

	private final GossipServis gossipServis;

	private final StockService stockService;

	private final WeatherService weatherService;

	public TelevisionBean(GossipServis gossipServis, StockService stockService,
			WeatherService weatherService) {
		if (gossipServis == null) {
			throw new IllegalArgumentException("GossipService must not be null");
		}
		if (stockService == null) {
			throw new IllegalArgumentException("StockService must not be null");
		}
		if (weatherService == null) {
			throw new IllegalArgumentException(
					"WeatherService must not be null");
		}
		this.gossipServis = gossipServis;
		this.stockService = stockService;
		this.weatherService = weatherService;
	}

	@Override
	public String getNews() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(gossipServis.getGossip()).append(" ")
				.append(stockService.getStockPricrice()).append(" ")
				.append(weatherService.getWeatherForesee());
		return stringBuilder.toString();
	}

}
