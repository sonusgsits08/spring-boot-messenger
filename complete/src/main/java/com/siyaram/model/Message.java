package com.siyaram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name = "MESSAGE")
@Entity(name = "Message")
public class Message {
	@Id
	@Column(name = "MESSAGE_ID")
	private String messageId;

	@Column(name = "MESSAGE_CONTENT")
	private String messageContent;
}
