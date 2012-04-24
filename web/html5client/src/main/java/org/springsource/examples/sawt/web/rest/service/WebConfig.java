package org.springsource.examples.sawt.web.rest.service;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springsource.examples.sawt.services.jpa.JpaConfiguration;

@EnableWebMvc
@Import(JpaConfiguration.class)
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/web/**").addResourceLocations("/web/");
	}

	@Override
	public void configureDefaultServletHandling( DefaultServletHandlerConfigurer configurer) {
 	 configurer.enable();
	}
	
	
}