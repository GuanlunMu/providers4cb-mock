package org.caringbridge.providers.config;

import javax.servlet.Filter;

import org.caringbridge.providers.filters.CorrelationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

	@Bean
	public Filter correlationFilter() {
		return new CorrelationFilter();
	}
}
