package com.example.dubbo.demo.web.controller;

import com.example.dubbo.demo.web.service.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * demo 控制器
 *
 * @author jeftom
 * @date 2019-03-24 00:51
 * @since 1.0.0
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private DemoService demoService;

	/**
	 * 测试方法，浏览器访问 /demo/index 可以看到响应结果了
	 *
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	@ResponseBody
	public String index() {
		return demoService.sayHello("dubbo");
	}
}
