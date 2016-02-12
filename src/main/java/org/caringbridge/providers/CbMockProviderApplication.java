package org.caringbridge.providers;

import org.caringbridge.common.services.annotations.EnableCorrelationFilter;
import org.caringbridge.common.services.annotations.EnableTrackRequestTime;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

/**
 * Main class for the provider micro-service.
 *
 * @author guanlun.mu
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@EnableCorrelationFilter
@EnableTrackRequestTime
@ComponentScan("org.caringbridge.providers")
public class CbMockProviderApplication {

	/**
	 * Main entry class for the mock provider-services application.
	 *
	 * @param args
	 *            The command line arguments for the app
	 */
	public static void main(final String[] args) {
		SpringApplication.run(CbMockProviderApplication.class, args);

	}
}
