package org.caringbridge.providers.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;

@Configuration
@EnableSwagger
public class SwaggerConfig {

	@Autowired
	private SpringSwaggerConfig springSwaggerConfig;

	public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig) {
		this.springSwaggerConfig = springSwaggerConfig;
	}

	@Bean
	public SwaggerSpringMvcPlugin customImplementation() {
		return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns("/.*");
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Mock Service API", "API for mocked third party fundraising provider",
				"API terms of service", "GuanlunMu@gmail.com", "Mock API Licence Type", "Mock API License URL");
		return apiInfo;
	}

}
