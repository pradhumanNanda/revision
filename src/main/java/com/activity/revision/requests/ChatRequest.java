package com.activity.revision.requests;

import java.util.List;
import lombok.Data;

@Data
public class ChatRequest {
	
	private List<Messages> messages;
	
	private String model;

}
