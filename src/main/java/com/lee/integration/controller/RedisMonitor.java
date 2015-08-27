package com.lee.integration.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/integration/v1")
public class RedisMonitor {

	@Autowired
	private StringRedisTemplate stringRedisTemplate;
	float maxSize = 4294967295F;

	@RequestMapping("/monitor/major")
	@ResponseBody
	public Map<String, String> monitorMajor() {
		long size = stringRedisTemplate.opsForList().size("jin.queue.receive");
		Map<String, String> resultMap = new HashMap<String, String>();
		resultMap.put("jin.queue.receive", (size / maxSize) * 100 + "% (" + size + ")");
		resultMap.put("11", "222");
		return resultMap;
	}
}