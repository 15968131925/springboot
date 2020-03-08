package com.cql.springbootwebrestfulcurd.config;

import com.cql.springbootwebrestfulcurd.component.LoginHandlerInterceptor;
import com.cql.springbootwebrestfulcurd.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;

//@EnableWebMvc //配置完这个之后所有springmvc自动配置的组件都失效了
//使用webMvcCOnfigurerAdapter 可以用来拓展springMVC的功能
@Configuration
public class MyMVCConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // super.addViewControllers(registry);
        //浏览器发送/springboot
        registry.addViewController("/springboot").setViewName("success");

    }


    //所有的WebMvcConfigurerAdapter 组件都会一起起作用
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter adapter =  new WebMvcConfigurerAdapter() {
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**").
                        excludePathPatterns("/index.html","/","/user/login");

            }
        };



        return adapter;
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


}
