package com.coco.redis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import redis.clients.jedis.JedisPoolConfig;

/**** @Configuration 表示这是一个java配置文件，Spring的容器会根据它来生成Ioc容器去装配Bean ****/
//@Configuration
public class RedisConfig {

	private RedisConnectionFactory connectionFactory = null;

	/**** @Bean 表示方法返回的Pojo装配到Ioc容器中，名称为 redisConnectionFactory ****/
	@Bean(name = "redisConnectionFactory")
	public RedisConnectionFactory initConnectionFactory() {
		if (this.connectionFactory != null) {
			return this.connectionFactory;
		}
		JedisPoolConfig poolConfig = new JedisPoolConfig();
		// 最大空闲数
		poolConfig.setMaxIdle(50);
		// 最大连接数
		poolConfig.setMaxTotal(100);
		// 最大等待毫秒数
		poolConfig.setMaxWaitMillis(2000);
		// 创建Jedis连接工厂
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		// 配置Redis连接服务器
		RedisStandaloneConfiguration rsc = connectionFactory.getStandaloneConfiguration();
		rsc.setHostName("114.215.44.53");
		rsc.setPort(6379);
		rsc.setPassword(RedisPassword.of("redisredis"));
		this.connectionFactory = connectionFactory;
		return connectionFactory;
	}
	
	@Bean(name="redisTemplate")
	public RedisTemplate<Object, Object> initRedisTemplate() {
	    RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<>();
	    redisTemplate.setConnectionFactory(initConnectionFactory());
	    RedisSerializer<String> stringRedisSerializer = redisTemplate.getStringSerializer();
	    redisTemplate.setKeySerializer(stringRedisSerializer);
	    redisTemplate.setValueSerializer(stringRedisSerializer);
	    redisTemplate.setHashKeySerializer(stringRedisSerializer);
	    redisTemplate.setHashValueSerializer(stringRedisSerializer);
	  return redisTemplate;
	}
}