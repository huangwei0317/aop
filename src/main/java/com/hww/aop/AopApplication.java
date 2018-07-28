package com.hww.aop;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@EnableScheduling
@RestController
@EnableSwagger2Doc
public class AopApplication /*extends SpringBootServletInitializer*/ {

    public static void main(String[] args) {
        SpringApplication.run(AopApplication.class, args);
    }

    //打war包时启用
    /* @Override
     protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
         return application.sources(AopApplication.class);
     }*/
    @Resource
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Scheduled(fixedDelay = 10000)
    public BaseResponse<User> aspect1() {
        User user = new User(1,"admin",new Date().toString());
        String str = "sss";
        restTemplate.postForObject("http://127.0.0.1:8080/test2?str="+str, user, String.class);
        return null;
    }

    @PostMapping(value = "/test2")
    public String test2(@RequestParam String str, @RequestBody User user){
        System.out.println();
        return "";
    }
}
