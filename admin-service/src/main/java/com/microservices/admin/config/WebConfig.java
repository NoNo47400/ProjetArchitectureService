package com.microservices.admin.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * WebConfig is a configuration class that implements the WebMvcConfigurer interface.
 * It is used to configure CORS (Cross-Origin Resource Sharing) settings for the application.
 * 
 * The addCorsMappings method is overridden to allow specific CORS configurations:
 * - Allows requests from the origin "http://localhost:8080".
 * - Permits HTTP methods: GET, POST, PUT, DELETE, and OPTIONS.
 * - Allows all headers.
 * - Supports credentials in CORS requests.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://localhost:8080")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
}
