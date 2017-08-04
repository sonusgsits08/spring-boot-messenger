package com.siyaram.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.siyaram.dto.MessageDto;
import com.siyaram.mapper.MessageConvertor;
import com.siyaram.message.SendMessage;
import com.siyaram.model.Message;

@Service
public class MessageService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private MessageConvertor messageConvertor;
	
	@Autowired
	private SendMessage sendMessage;

	@SuppressWarnings("unchecked")
	public Map<String, List<MessageDto>> getMessage(String messageId) throws IOException {		
		List <Message> dbMessages=null;
		List<MessageDto> messageDtos=null;
		Query query =  entityManager.createQuery("from Message where messageId = :messageId");
		query.setParameter("messageId", messageId);
		dbMessages = query.getResultList();
		messageDtos = messageConvertor.convertMessagetoMessageDto(dbMessages);
		Map<String,List<MessageDto>> response = new HashMap<>();
		//SEND MQ MESSAGE WHEN NO MESSAGE IS FOUND IN DATABSE
		if(CollectionUtils.isEmpty(messageDtos)){			
			sendMessage.sendRabbitMessage(messageId);
		}
		response.put(messageId, messageDtos);
		return response;
	}

	@Transactional
	public void updateMessage(MessageDto inputMessageDto) {
		List<MessageDto> msgDto = new ArrayList<>();
		msgDto.add(inputMessageDto);
		List<Message> messages = messageConvertor.convertMessageDtotoMessage(msgDto);
		entityManager.merge(messages.get(0));			
	}
}
