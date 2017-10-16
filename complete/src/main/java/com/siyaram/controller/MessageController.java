package com.siyaram.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.siyaram.dto.MessageDto;
import com.siyaram.model.Message;
import com.siyaram.service.MessageService;

@RestController
public class MessageController {
	
	@Autowired
	private MessageService messageService;

	@RequestMapping(method = RequestMethod.GET , value = "/getMessage/{messageId}")
	@ResponseBody
	public Map<Long , List<MessageDto>>  getMessage(@PathVariable Long messageId) throws IOException{
		return messageService.getMessage(messageId);		
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/udpateMessage/{messageId}" , consumes ={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	public Message updateMessage(@PathVariable Long messageId , @RequestBody MessageDto inputMessageDto){
		inputMessageDto.setMessage_id(messageId);
		Message msg =messageService.updateMessage(inputMessageDto);
		return msg;
	}
	@RequestMapping(method=RequestMethod.POST,value="/createMessage",consumes={MediaType.APPLICATION_JSON_VALUE})
	@ResponseBody
	@ResponseStatus(value=HttpStatus.CREATED)
	public void createMessage(@RequestBody MessageDto createMessageDto){
		 messageService.createMessage(createMessageDto);		
	}
	@RequestMapping("/")
    public String greeting() {
        return "Greetings from Spring Boot! sonu";
    }
}