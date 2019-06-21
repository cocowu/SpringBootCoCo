package com.coco.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;



/*
 * redis使用快速参考： https://www.vpser.net/manage/nano.html
 * 
 * 安装与 114.215.44.53 演示服务器，端口 6379，口令：redisredis，端口开放
 * 
 * ubuntu redis 安装：   apt-get install redis-server
 * 
 * 检查Redis服务器系统进程：ps -aux|grep redis
 *                          netstat -nlt|grep 6379
 *                          
 * 通过启动命令检查Redis服务器状态： /etc/init.d/redis-server status
 * 
 * 通过命令行客户端访问Redis： redis-cli
 *                             redis-cli -a redisredis
 * 
 * 客户端基本命令：
 *    set key1 "hello"
 *    get key1
 *    keys *
 *    del key1
 * 
 * 重启服务：/etc/init.d/redis-server restart
 * */

public class Main {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(RedisConfig.class);
		RedisTemplate redisTemplate = ctx.getBean(RedisTemplate.class);
		
		// 以下两条实际上是在不同的连接中执行的，效率不高
		redisTemplate.opsForValue().set("key1", "value1");
		redisTemplate.opsForHash().put("hash", "field1", "hvalue1");
		
		// SessionCallback接口和RedisCallback接口,它们的作用是让 redisTemplate 进行回调，
		// 通过它们可以再同一个连接下执行多条redis命令。
		useSessionCallback(redisTemplate);
		useRedisCallback(redisTemplate);
		ctx.close();
	}
	
	// 使用 Lambda 表达式的写法
	public static void useRedisCallback(RedisTemplate redisTemplate) {
	    redisTemplate.execute((RedisConnection rc) -> {
	        rc.set("key2".getBytes(), "value2".getBytes());
	        rc.hSet("hash".getBytes(), "field2".getBytes(), "hvalue2".getBytes());
	        return null;
	    });
	}

	// 使用 Lambda 表达式的写法
	public static void useSessionCallback(RedisTemplate redisTemplate) {
	    redisTemplate.execute((RedisOperations ro) -> {
	        ro.opsForValue().set("key3", "value3");
	        ro.opsForHash().put("hash", "field3", "hvalue3");
	        return null;
	    });
	}
	
//	// 需要处理底层的转换规则，如果不考虑改写底层，尽量不使用它
//	public static void useRedisCallback(RedisTemplate redisTemplate) {
//	    redisTemplate.execute(new RedisCallback() {
//	        @Override
//	        public Object doInRedis(RedisConnection rc) 
//	                throws DataAccessException {
//	            rc.set("key1".getBytes(), "value1".getBytes());
//	            rc.hSet("hash".getBytes(), "field".getBytes(), "hvalue".getBytes());
//	            return null;
//	        }
//	    });
//	}
//
//	// 高级接口，比较友好，一般情况下，优先使用它
//	public static void useSessionCallback(RedisTemplate redisTemplate) {
//	    redisTemplate.execute(new SessionCallback() {
//	        @Override
//	        public Object execute(RedisOperations ro) 
//	                throws DataAccessException {
//	            ro.opsForValue().set("key1", "value1");
//	            ro.opsForHash().put("hash", "field", "hvalue");
//	            return null;
//	        }
//	    });
//	}
}
