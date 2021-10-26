package com.seeing.config;

import com.seeing.interceptor.TokenInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {


    /**
     * 拦截器，拦截没有token的
     * @param registry
     */
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new TokenInterceptor()).addPathPatterns("/**")
        .excludePathPatterns("/user/tokenExpire","/user/hello","/user/login","/user/register",
            "/user/forget","/user/verify","/user/reset_password"); }

}



