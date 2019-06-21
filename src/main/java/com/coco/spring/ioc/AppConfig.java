package com.coco.spring.ioc;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;


/**** @Configuration 表示这是一个java配置文件，Spring的容器会根据它来生成Ioc容器去装配Bean ****/
@Configuration
 
/**** @ComponentScan 表示会进行扫描，如果不加参数只会扫描自身的包或子包，这里的演示都放在一个包中，故不加参数,
                       lazyInit=true 表示延时注入 ****/
// @ComponentScan(basePackages = "com.springboot.chapter3.*", lazyInit=true)
@ComponentScan
//@ImportResource(value = {"classpath:spring-other.xml"})
public class AppConfig {
	
//	@Bean(name = "dataSource", destroyMethod = "close")
//	@Conditional(DatabaseConditional.class)
//	public DataSource getDataSource(
//			@Value("${database.driverName}") String driver,
//			@Value("${database.url}") String url,
//			@Value("${database.username}") String username, 
//			@Value("${database.password}") String password
//			) {
//		Properties props = new Properties();
//		props.setProperty("driver", driver);
//		props.setProperty("url", url);
//		props.setProperty("username", username);
//		props.setProperty("password", password);
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
	
	
//	@Bean(name = "dataSource", destroyMethod = "close")
//	@Profile("dev")
//	public DataSource getDevDataSource() {
//		Properties props = new Properties();
//		props.setProperty("driver", "com.mysql.jdbc.Driver");
//		props.setProperty("url", "jdbc:mysql://localhost:3306/dev_spring_boot");
//		props.setProperty("username", "root");
//		props.setProperty("password", "123456");
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
//	
//	
//	@Bean(name = "dataSource", destroyMethod = "close")
//	@Profile("test")
//	public DataSource getTestDataSource() {
//		Properties props = new Properties();
//		props.setProperty("driver", "com.mysql.jdbc.Driver");
//		props.setProperty("url", "jdbc:mysql://localhost:3306/test_spring_boot");
//		props.setProperty("username", "root");
//		props.setProperty("password", "123456");
//		DataSource dataSource = null;
//		try {
//			dataSource = BasicDataSourceFactory.createDataSource(props);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return dataSource;
//	}
}