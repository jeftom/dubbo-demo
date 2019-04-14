package com.example.dubbo.demo.service.impl;

import com.example.dubbo.demo.api.DemoApi;
import com.example.dubbo.demo.service.config.DataSourceEnum;
import com.example.dubbo.demo.service.config.DynamicDataSource;
import com.example.dubbo.demo.service.mapper.SeckillMapper;
import com.example.dubbo.demo.service.entity.Seckill;
import org.apache.dubbo.config.annotation.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * class description
 *
 * @author jeftom <jeftom@tenwe.com>
 * @date 2019-03-23 23:04
 * @since 1.0.0
 */
@Service
public class DemoApiImpl implements DemoApi {
	@Resource
	private SeckillMapper seckillMapper;

	/**
	 * 实现 sayHello 接口
	 *
	 * @param name
	 * @return
	 */
	@Override
	public String sayHello(String name) {
		DynamicDataSource.setDataSource(DataSourceEnum.SLAVE.getName());
		List<Seckill> list = seckillMapper.queryAll(0,4);
		return "Hello, " + name + " (from Spring Boot with dubbo-2.7.1)" + list.toString();
	}
}
