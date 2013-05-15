package com.impaq.ic.spring.javaconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Lazy;

import com.impaq.ic.spring.javaconfig.receiver.PowerStationBean;
import com.impaq.ic.spring.javaconfig.receiver.PowerStationService;
import com.impaq.ic.spring.javaconfig.receiver.SamsungTvSetBean;
import com.impaq.ic.spring.javaconfig.receiver.SonyTvSetBean;
import com.impaq.ic.spring.javaconfig.receiver.TvSetService;
import com.impaq.ic.spring.javaconfig.receiver.ViewerBean;
import com.impaq.ic.spring.javaconfig.receiver.ViewerService;
import com.impaq.ic.spring.javaconfig.tv.StationAppConfig;
import com.impaq.ic.spring.javaconfig.tv.TelevisionService;


@Configuration
//!! zaczytanie konfiguracji z klasy StationAppConfig
@Import({ StationAppConfig.class })
public class AppConfig {

	private static final String POWER_PLANT_BEAN = "powerPlant";

	//zdefiniowany w klassie StationAppConfig
	@Autowired
	private TelevisionService televisionService;

	@Autowired
	@Qualifier("Sony")
	private TvSetService tvSetService;

	public @Bean
	@Qualifier("Samsung")
	TvSetService tvSetServiceSamsung() {
		return new SamsungTvSetBean(televisionService);
	}

	@Bean
	@Qualifier("Sony")
	@DependsOn(POWER_PLANT_BEAN)
	public TvSetService tvSetServiceSony() {
		return new SonyTvSetBean(televisionService);
	}

	public @Bean
	ViewerService viewerService() {
		return new ViewerBean(tvSetService);
	}

	@Bean(name = POWER_PLANT_BEAN)
	@Lazy
	public PowerStationService powerStationService() {
		return new PowerStationBean();
	}

}
