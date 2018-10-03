package com.thorxh.xh.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * created on 2018/10/3
 *
 * @author thorxh
 */
//@Configuration
public class CustomCorsConfiguration {

//    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // 限制了路径和域名的访问
                registry.addMapping("/pa/*").allowedOrigins("http://127.0.0.1:8080");
            }
        };
    }

}
