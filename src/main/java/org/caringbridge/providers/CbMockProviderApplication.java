package org.caringbridge.providers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
/**
 * Main class for the provider micro-service.
 *
 * @author guanlun.mu
 *
 */

//@SpringBootApplication
@EnableAutoConfiguration()
@ComponentScan("org.caringbridge.providers")
public class CbMockProviderApplication {

    /**
     * Main entry class for the mock provider-services application.
     *
     * @param args The command line arguments for the app
     */
    public static void main(final String[] args) {
	SpringApplication.run(CbMockProviderApplication.class, args);

    }
}
