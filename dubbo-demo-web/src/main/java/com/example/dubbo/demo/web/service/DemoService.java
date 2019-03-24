package com.example.dubbo.demo.web.service;

import com.example.dubbo.demo.api.DemoApi;
import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 消费者服务层
 *
 * @author jeftom
 * @date 2019-03-24 00:49
 * @since 1.0.0
 */
@Service
public class DemoService {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoService.class);

	@Reference
	private DemoApi demoApi;

	public String sayHello(String name) {
		return demoApi.sayHello(name);
	}
}
