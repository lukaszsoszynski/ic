package com.impaq.ic.spring.javaconfig.tv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.impaq.ic.spring.javaconfig.tv.gossip.GossipBean;
import com.impaq.ic.spring.javaconfig.tv.gossip.GossipServis;
import com.impaq.ic.spring.javaconfig.tv.stock.StockBean;
import com.impaq.ic.spring.javaconfig.tv.stock.StockService;
import com.impaq.ic.spring.javaconfig.tv.weather.WeatherBean;
import com.impaq.ic.spring.javaconfig.tv.weather.WeatherService;

@Configuration
public class StationAppConfig {

	@Autowired
	private GossipServis gossipServis;

	@Autowired
	private StockService stockService;

	@Autowired
	private WeatherService weatherService;

	@Scope(BeanDefinition.SCOPE_SINGLETON)
	public @Bean(name = { "weatherService", "fortuneTeller" })
	WeatherService weatherService() {
		return new WeatherBean();
	}

	public @Bean
	StockService stockService() {
		return new StockBean();
	}

	public @Bean
	GossipServis gossipServis() {
		return new GossipBean();
	}

	public @Bean
	TelevisionService televisionService() {
		return new TelevisionBean(gossipServis, stockService, weatherService);
	}

}
