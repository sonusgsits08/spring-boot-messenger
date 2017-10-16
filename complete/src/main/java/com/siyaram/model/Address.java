package com.siyaram.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Data
@Entity
public class Address {

	@Id
	@Column(name = "AID")
	@SequenceGenerator(name = "address_seq", sequenceName = "address_seq", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator="address_seq")
	private Long addressId;

	@Column(name = "LOCATION")
	private String location;
	
	@Column(name="ADD_MESSAGE_ID")
	private Long messageId;

}
