package com.example.dubbo.demo.service;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableDubboConfig
@DubboComponentScan("com.example.dubbo.demo.service.impl")
@SpringBootApplication
@EnableTransactionManagement
public class DubboDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DubboDemoServiceApplication.class, args);
	}

}
