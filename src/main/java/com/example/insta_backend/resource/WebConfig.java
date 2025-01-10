package com.example.insta_backend.resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")  // Allow all endpoints
                .allowedOrigins("*")  // Allow all origins
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")  // Allow HTTP methods
                .allowedHeaders("*")  // Allow all headers
                .allowCredentials(false)  // Set to false if credentials (cookies, auth headers) are not required
                .maxAge(3600);  // Cache the pre-flight response for 1 hour
    }
}
