package com.lee.integration.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.redis.RedisAutoConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lee.integration.app.App;
import com.lee.integration.service.IntMsgService;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = { "com.lee.integration" })
@SpringApplicationConfiguration(classes = App.class)
@EnableAutoConfiguration(exclude = { RedisAutoConfiguration.class })
public class IntegrationTest {

	@Autowired
	private IntMsgService intMsgService;
	@Autowired
	@Qualifier("channelSend")
	private MessageChannel channel;

	@Test
	public void sendMessage() throws InterruptedException {
		System.out.println("---------------------------------------------------------------");
		long time = System.currentTimeMillis();
		intMsgService.send("11111111111111");
		intMsgService.send("22222222222222");
		intMsgService.send("33333333333333");
		intMsgService.send("44444444444444");
		intMsgService.send("55555555555555");
		intMsgService.send("66666666666666");
		System.out.println("Gateway >>>>>>>>>>>> : " + (System.currentTimeMillis() - time));
		System.out.println("---------------------------------------------------------------");
	}

	@Test
	public void sendMsgWithQueue() {
		System.out.println("---------------------------------------------------------------");
		long time = System.currentTimeMillis();
		channel.send(new GenericMessage<String>("aaaaaaaaaaaaaaaaaaaaaa"));
		channel.send(new GenericMessage<String>("bbbbbbbbbbbbbbbbbbbbbb"));
		channel.send(new GenericMessage<String>("cccccccccccccccccccccc"));
		channel.send(new GenericMessage<String>("dddddddddddddddddddddd"));
		channel.send(new GenericMessage<String>("eeeeeeeeeeeeeeeeeeeeee"));
		channel.send(new GenericMessage<String>("ffffffffffffffffffffff"));
		System.out.println("Queue >>>>>>>>>>>> : " + (System.currentTimeMillis() - time));
		System.out.println("---------------------------------------------------------------");
	}
}
