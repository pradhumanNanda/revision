package com.activity.revision.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseStatus {

	private Integer statusCode;
	
	private String message;
	
	private Object response;
	
	public ResponseStatus(SystemError systemError){
		super();
		this.statusCode = systemError.getStatusCode();
		this.message = systemError.getStatusMessage();
	}
	
}
