package com.siyaram.message;


import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.siyaram.Application;


@Component("sendMessage")
public class SendMessage{

	private RabbitTemplate rabbitTemplate;
	@Autowired
	SendMessage(RabbitTemplate rabbitTemplate){
		this.rabbitTemplate=rabbitTemplate;
	}
		
	public void sendRabbitMessage(String messageId){	
		  Map<String, String> actionmap = new HashMap<>();
	        actionmap.put("id", messageId);
		rabbitTemplate.convertSendAndReceive(Application.queueName,actionmap);		
//		ConnectionFactory factory = new ConnectionFactory();
//		factory.setHost("localhost");
//		factory.setPort(15672);
//		factory.setUsername("guest");
//		factory.setPassword("guest");
//		connection = factory.newConnection();
//		channel = connection.createChannel();
//		//channel.queueDeclare(endPointName,false,false,false,null);
//		//channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
//		channel.close();
//		connection.close();
	}
}
