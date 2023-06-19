package com.example.demo.configs;
import com.example.demo.intercepter.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;
import java.util.Locale;
@Configuration
@CrossOrigin
public class MvcConfig implements WebMvcConfigurer {

    @Resource
    JwtInterceptor jwtInterceptor;
    /**
     * 添加jwt拦截器，并指定拦截路径
     * */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/user/user/**","/userJob/**","/userBaseInfo/**","/eduInfo/**","/jobInfo/**","/userJob/**"
                ,"/complaint/save");
    }

//    /**
//     * jwt拦截器
//     * */
//    @Bean
//    public JwtInterceptor jwtInterceptor() {
//        return new JwtInterceptor();
//    }
}
