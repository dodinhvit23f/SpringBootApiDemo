package com.vnnews.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class ApiConfig implements WebMvcConfigurer   {
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("api/**")
        .allowedOrigins("*")
        .allowedOrigins("http://localhost:3000/")
        .allowCredentials(false).maxAge(3600);
    }
	
	/*
	@Bean
	public FilterRegistrationBean<CorsFilter> setupCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();	
		config.addAllowedHeader("*");
		config.addAllowedMethod("*");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(source));
		bean.setOrder(0);
		return bean;
	}*/
	
	
}
