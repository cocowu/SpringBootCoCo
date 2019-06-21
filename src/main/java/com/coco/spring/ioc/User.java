package com.coco.spring.ioc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component 表示会被扫描装配进容器
@Component("user")
public class User {

	// @Value 指定初始值
	@Value("1")
	private Long id;
	
	@Value("user_name_1")
	private String userName;
	
	// 读取配置文件中的设置
	@Value("${spring.redis.host}")
	private String note;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
}
