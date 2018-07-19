package com.sdyy.excemple.springbootdome.config;

import com.sdyy.excemple.springbootdome.compone.LoginInterceptorHandle;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置自己的配置文件，并加入到springboot中
 */
@Configuration
public class MyConfig {
    /**
     * 加入映射，拦截器
     * @return webMvcConfigurerAdapter
     */
    @Bean
    public WebMvcConfigurerAdapter adapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
               // super.addViewControllers(registry);
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                //super.addInterceptors(registry);
                registry.addInterceptor(new LoginInterceptorHandle()).addPathPatterns("/**")
                        .excludePathPatterns("/","/index.html","/user/login");
            }
        };
        return adapter;
    }

    /**
     *把国家化配置加入进来
     */
    @Bean
    public MyLocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

}
