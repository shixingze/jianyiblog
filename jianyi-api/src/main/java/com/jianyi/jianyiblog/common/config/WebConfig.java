package com.jianyi.jianyiblog.common.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ Author     ：johnbarrowman65
 * @ Date       ：Created in 11:06 2019/8/15
 * @ Description：
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    // 在D:/res/pic下如果有一张 luffy.jpg.jpg的图片，那么：
    // 1 访问：http://localhost:8080/img/luffy.jpg 可以访问到
    // 2 html 中 <img src="http://localhost:8080/img/luffy.jpg">
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/cover/**").addResourceLocations("file:/jianyi/upload/cover/");
    }

    /*@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**").addResourceLocations("file:/root/feedback/");
    }*/
}