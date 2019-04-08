package com.ycy.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
 
@Configuration
public class MyWebMvcConfigurerAdapter extends WebMvcConfigurerAdapter {
 
    //图片存放根路径
    @Value("${uploadfile.rootPath}")
    private String ROOT_PATH;
    //图片存放根目录下的子目录
    @Value("${uploadfile.sonPath}")
    private String SON_PATH;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        String filePath = "file:" + ROOT_PATH + SON_PATH;
        //指向外部目录
        registry.addResourceHandler("/ycy/img//**").addResourceLocations(filePath);
        super.addResourceHandlers(registry);
    }
    
    @Override
    public void addCorsMappings(CorsRegistry registry) {
      registry.addMapping("/point/*").allowedOrigins("*");
    }

    
}