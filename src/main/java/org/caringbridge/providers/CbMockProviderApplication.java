package org.caringbridge.providers;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.context.WebApplicationContext;
/**
 * Main class for the provider micro-service
 * @author guanlun.mu
 *
 */

@SpringBootApplication
@ComponentScan("org.caringbridge.providers")
public class CbMockProviderApplication {
    public static void main(final String[] args){
	SpringApplication.run(CbMockProviderApplication.class, args);

    }
}
