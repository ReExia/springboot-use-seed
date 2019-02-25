package com.example.restapi.config.inteceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {

    private static final List<String> EXCLUDE_PATH = Arrays.asList(
            "/webjars/**",
            "/swagger-ui.html",
            "/swagger-resources/**"
            );

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new HttpInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATH);
    }

}
