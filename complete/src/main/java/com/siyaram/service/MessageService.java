package com.siyaram.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.siyaram.dto.MessageDto;
import com.siyaram.mapper.MessageConvertor;
import com.siyaram.model.Message;

@Service
public class MessageService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Autowired
	private MessageConvertor messageConvertor;

	@SuppressWarnings("unchecked")
	public Map<String, List<MessageDto>> getMessage(String messageId) {
		List <Message> dbMessages=null;
		List<MessageDto> messageDtos=null;
		Query query =  entityManager.createQuery("from Message where messageId = :messageId");
		query.setParameter("messageId", messageId);
		dbMessages = query.getResultList();
		messageDtos = messageConvertor.convertMessagetoMessageDto(dbMessages);
		Map<String,List<MessageDto>> response = new HashMap<>();
		response.put(messageId, messageDtos);
		return response;
	}

}
