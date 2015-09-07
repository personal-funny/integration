package com.lee.integration.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.messaging.handler.annotation.Payload;

public interface IntMsgService {

	@Gateway
	public void send(@Payload String msg);
}
