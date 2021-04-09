package com.hacker.news.cofig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan(value = { "com.hacker.news" })
public class BaseConfig {

	/**
	 * RestTemplate bean
	 * 
	 * @return RestTemplate
	 */
	@Bean(name = "restTemplate")
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
