package com.lee.integration.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = { ComponentScan.class })
@EnableAutoConfiguration(exclude={RedisAutoConfiguration.class})
@ImportResource(value={"classpath:root-context.xml"})
public class App {
	static final Logger log = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
		log.info("Start ... ... OK !");
	}
}