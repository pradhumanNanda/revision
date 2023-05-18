package com.activity.revision.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStatus {

	private Integer statusCode;
	
	private String message;
	
	private Object object;
	
	public ResponseStatus(SystemError systemError){
		super();
		this.statusCode = systemError.getStatusCode();
		this.message = systemError.getStatusMessage();
	}
	
}
