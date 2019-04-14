package com.example.dubbo.demo.service.entity;

import lombok.Data;

/**
 * class description
 *
 * @author jeftom <jeftom@tenwe.com>
 * @date 2019-04-13 22:14
 * @since 1.0.0
 */
@Data
public class User {
	private Integer id;
	private String userName;
	private String authority;

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", userName='" + userName + '\'' +
				", authority='" + authority + '\'' +
				'}';
	}
}
