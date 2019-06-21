package com.coco.spring.ioc;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/*
 * 本包演示 Spring IOC 功能
 * 
 * */

@SpringBootApplication
// 下面一句一定要写，不然Spring找不到配置文件，虽然说会自动去找。
// classpath 估计包含 main 和 resources 两个目录
@PropertySource(value={"classpath:application.properties"}, ignoreResourceNotFound=true)
public class App {

	public static void main(String[] args) throws SQLException {
		
		// 从配置类 AppConfig 加载容器
		// AppConfig 类中 @ComponentScan 指定扫描本包中的 Bean
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
		
		// 在运行日志中，注意 BussinessPerson 的生命周期事件
		// 对第三方类，可以用 @Bean 来配置自定义初始化和销毁方法
		//      @Bean(initMethod="init", destroyMethod="destroy")
		
		// 测试创建的 user Bean , 配置文件属性自动注入
		User user = ctx.getBean(User.class);
		System.out.println("redis ip : " + user.getNote());
	}
	
	
	
	
}
