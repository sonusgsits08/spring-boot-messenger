package com.siyaram.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.siyaram.dto.MessageDto;
import com.siyaram.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET , value = "/getMessage/{messageId}")
	@ResponseBody
	public Map<String , List<MessageDto>>  getMessage(@PathVariable String messageId){
		return messageService.getMessage(messageId);		
	}
	@RequestMapping("/")
    public String greeting() {
        return "Greetings from Spring Boot! sonu";
    }
}
