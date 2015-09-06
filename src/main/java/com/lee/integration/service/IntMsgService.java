package com.lee.integration.service;

import java.util.Map;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;

public interface IntMsgService {

	@Gateway
	public void send(@Header Map<String, Object> map, @Payload String msg);
}
