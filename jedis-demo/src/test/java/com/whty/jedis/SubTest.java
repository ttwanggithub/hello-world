package com.whty.jedis;

import org.springframework.context.ApplicationContext;

import redis.clients.jedis.Jedis;

import com.whty.jedis.pubsub.MyListener;
import com.whty.jedis.util.RedisUtil;
import com.whty.jedis.util.SingletonContext;

public class SubTest {
	public static void main(String[] args) {
		ApplicationContext ac = SingletonContext.getInstance();
		RedisUtil ru = (RedisUtil) ac.getBean("redisUtil");	
		final Jedis jedis = ru.getConnection();
		final MyListener listener = new MyListener();
		new Thread(new Runnable() {
			@Override
			public void run() {
				//jedis.subscribe(listener, "foo", "watson");
				//jedis.subscribe(listener, new String[]{"whty_foo","whty_test"});
				jedis.psubscribe(listener, new String[]{"whty_*"});
			}
		}).start();
			
		System.out.println("==============");
	}
}
