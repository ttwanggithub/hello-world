package com.whty.jedis;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;

import com.whty.jedis.util.RedisUtil;

public class CommonTest {
	public static void main(String[] args) throws Exception {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans-config.xml");
		//BeanFactory factory  = new XmlBeanFactory((Resource) new ClassPath("beans-config.xml"));
		RedisUtil ru = (RedisUtil) ac.getBean("redisUtil");
		
		Jedis jedis = ru.getConnection();
		System.out.println(jedis != null);
	}
}
