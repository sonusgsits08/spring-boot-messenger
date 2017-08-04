package com.siyaram.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.xml.ws.soap.AddressingFeature.Responses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siyaram.dto.MessageDto;
import com.siyaram.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET , value = "/getMessage/{messageId}")
	@ResponseBody
	public Map<String , List<MessageDto>>  getMessage(@PathVariable String messageId) throws IOException{
		return messageService.getMessage(messageId);		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/udpateMessage/{messageId}" , consumes ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public void updateMessage(@PathVariable String messageId , @RequestBody MessageDto inputMessageDto){		
		messageService.updateMessage(inputMessageDto);		
	}
	@RequestMapping("/")
    public String greeting() {
        return "Greetings from Spring Boot! sonu";
    }
}