package com.webbucks.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ReactApiConfiguration implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**")
		.allowedOrigins("http://localhost:3000") // 허용할 출처 설정
		.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 HTTP 메서드 설정
		.allowedHeaders("*") // 모든 헤더 허용
		.allowCredentials(true); // 자격 증명 허용
	}
}
