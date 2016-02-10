package org.caringbridge.providers.config;


import org.caringbridge.common.services.annotations.EnableCorrelationFilter;
import org.springframework.boot.context.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.context.embedded.undertow.UndertowEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.undertow.Undertow.Builder;
import io.undertow.UndertowOptions;

@Configuration
@EnableCorrelationFilter
public class WebConfig {

//	/**
//	 * Adds the correlation filter that will get the correlation ID and populate it for logging and external calls.
//	 * @return
//	 */
//	@Bean
//	public Filter correlationFilter() {
//		return new CorrelationFilter();
//	}
	
//	/**
//	 * Sets the record-request-start-time to true so that Undertow will track the request time and report it in the 
//	 * access logs if the '%D' is added to the logging pattern.  
//	 * @return
//	 */
//	@Bean
//	public UndertowEmbeddedServletContainerFactory embeddedServletContainerFactory() {
//	    final UndertowEmbeddedServletContainerFactory undertowEmbeddedServletContainerFactory = new UndertowEmbeddedServletContainerFactory();
//	    undertowEmbeddedServletContainerFactory
//	            .addBuilderCustomizers(new UndertowBuilderCustomizer() {
//					@Override
//					public void customize(Builder builder) {
//						builder.setServerOption(UndertowOptions.RECORD_REQUEST_START_TIME, true);
//					}
//	            });
//	    return undertowEmbeddedServletContainerFactory;
//	}
}
