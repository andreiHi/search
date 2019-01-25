package com.arrival.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Cors configuration if web on another host
 * @author Victor Karetko.
 */
@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .exposedHeaders("Content-Disposition", "X-AUTH-TOKEN", "Location")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
