package com.siyaram.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.siyaram.dto.MessageDto;
import com.siyaram.model.Message;

@Component
public class MessageConvertor {
	
	public List<MessageDto> convertMessagetoMessageDto(List<Message> messages){
		List<MessageDto> messageDtos = new ArrayList<MessageDto>();		
		for(Message message : messages)
		{
			MessageDto messageDto = new MessageDto();
			messageDto.setMessage_id(message.getMessageId());
			messageDto.setMessage_content(message.getMessageContent());
			messageDtos.add(messageDto);			
		}
		return messageDtos;
	}
}
