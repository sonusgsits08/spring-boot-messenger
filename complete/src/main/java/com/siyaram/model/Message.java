package com.siyaram.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.context.annotation.Lazy;

import lombok.Data;

@Data
@Table(name = "MESSAGE")
@Entity(name = "Message")
public class Message {
	@Id
	@SequenceGenerator(name = "message_seq", sequenceName = "message_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="message_seq")
	@Column(name = "MESSAGE_ID")
	@JsonIgnore
	private Long messageId;

	@Column(name = "MESSAGE_CONTENT")
	private String messageContent;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="ADD_MESSAGE_ID",referencedColumnName="MESSAGE_ID" )
	@Lazy
	private List<Address> receivers;
}
