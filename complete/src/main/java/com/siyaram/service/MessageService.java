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

import com.google.common.collect.Lists;
import com.siyaram.dto.MessageDto;
import com.siyaram.mapper.MessageConvertor;
import com.siyaram.model.Message;

@Service
public class MessageService {
	
	@PersistenceContext(name = "entityManager")
	private transient EntityManager entityManager;
	
	@Autowired
	private MessageConvertor messageConvertor;
	
	@SuppressWarnings("unchecked")
	public Map<Long, List<MessageDto>> getMessage(Long messageId) throws IOException {		
		List <Message> dbMessages=null;
		List<MessageDto> messageDtos=null;
		Query query =  entityManager.createQuery("from Message where messageId = :messageId");
		query.setParameter("messageId", messageId);
		dbMessages = query.getResultList();
		messageDtos = messageConvertor.convertMessagetoMessageDto(dbMessages);
		Map<Long,List<MessageDto>> response = new HashMap<>();		
		response.put(messageId, messageDtos);
		return response;
	}

	@Transactional
	public Message updateMessage(MessageDto inputMessageDto) {
		List<MessageDto> msgDto = new ArrayList<>();
		msgDto.add(inputMessageDto);
		List<Message> messages = messageConvertor.convertMessageDtotoMessage(msgDto);
		Message msg = entityManager.merge(messages.get(0));
		return msg;
	}
	@Transactional
	public void createMessage(MessageDto createMessageDto) {		
		List<Message> messages = messageConvertor.convertMessageDtotoMessage(Lists.newArrayList(createMessageDto));		
			entityManager.persist(messages.get(0));
			entityManager.flush();		
	}
}
