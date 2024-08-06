package com.springServer.springServer.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

@Configuration
public class MultipartSupportConfig {

    @Bean
    public Encoder feignFormEncoder() {
        return new SpringFormEncoder();
    }
}
