package com.example.demo.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.example.demo.models.Flight;
import com.example.demo.models.User;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example.demo.controllers")
public class MvcConfig implements WebMvcConfigurer {
	
	@Bean
	public InternalResourceViewResolver resolver() {
		
		InternalResourceViewResolver resolver=new InternalResourceViewResolver();
		
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	@Bean
	public ModelAndView mdlView() {
		return new ModelAndView();
	}
	
	@Bean
	public Flight flight() {
		return new Flight();
	}
	
	@Bean
	public User user() {
		return new User();
	}
}
