package com.whty.jedis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;

import com.whty.jedis.util.RedisUtil;
import com.whty.jedis.util.SingletonContext;

public class PubTest {
	public static void main(String[] args) {
		ApplicationContext ac = SingletonContext.getInstance();
		//ApplicationContext ac = new ClassPathXmlApplicationContext("beans-config.xml");
		RedisUtil ru = (RedisUtil) ac.getBean("redisUtil");	
		Jedis jedis = ru.getConnection();
		jedis.publish("whty_foo", "bar123");
		jedis.publish("whty_test", "hello watson");
	}
}
