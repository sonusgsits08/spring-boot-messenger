package com.siyaram.dto;

import java.util.List;

import com.siyaram.model.Address;

import lombok.Data;

@Data
public class MessageDto {
	private Long message_id;
	private String message_content;
	private List<Address> receivers;
}
