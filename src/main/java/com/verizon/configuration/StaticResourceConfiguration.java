package com.verizon.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

	@Value("${keepalive.path}")
	private String path;

	@Value("${keepalive.file}")
	private String file;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(path).addResourceLocations(file);
	}

}
