package com.example.dubbo.demo.web;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfig
@DubboComponentScan("com.example.dubbo.demo.web.service")
@SpringBootApplication
public class DubboDemoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboDemoWebApplication.class, args);
	}

}
