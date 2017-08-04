package com.siyaram.message;

import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class MessageReceiver {

	public void receiveMessage(Map<String,String> messageMap){
		System.out.println("message received is "+messageMap.get("1"));
	}
}
