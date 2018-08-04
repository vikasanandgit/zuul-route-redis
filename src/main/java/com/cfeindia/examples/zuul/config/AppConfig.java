package com.cfeindia.examples.zuul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import com.cfeindia.examples.zuul.model.DynamicRoute;

import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class AppConfig {

	private static final int REDIS_PORT = 6379;
	private static final String REDIS_HOST_NAME = "localhost";
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		JedisPoolConfig poolConfig = new JedisPoolConfig();

		//Change the configuration as per requirement
		poolConfig.setMaxTotal(128);
		poolConfig.setTestOnBorrow(true);
		poolConfig.setTestOnReturn(true);
		poolConfig.setMinIdle(5);
		poolConfig.setMaxIdle(128);
		
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory(poolConfig);
		connectionFactory.setUsePool(true);
		connectionFactory.setHostName(REDIS_HOST_NAME);
		connectionFactory.setPort(REDIS_PORT);
		
		return connectionFactory;
	}
	@Bean
	public RedisTemplate<String, DynamicRoute> redisTemplate() {
		RedisTemplate<String, DynamicRoute> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		redisTemplate.setEnableTransactionSupport(false);
		return redisTemplate;
	}
}
